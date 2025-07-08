package com.seyitkoc.service.impl;

import com.seyitkoc.service.*;
import com.seyitkoc.service.base.ApartmentDebtsBaseService;
import com.seyitkoc.mapper.ApartmentDebtsMapper;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.entity.Debt;
import com.seyitkoc.mapper.DebtMapper;
import com.seyitkoc.repository.DebtRepository;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.Building;
import com.seyitkoc.entity.ApartmentDebts;
import com.seyitkoc.entity.Due;
import com.seyitkoc.enums.DebtType;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DebtServiceImpl implements IDebtService {
    private final DebtRepository debtRepository;
    private final IUserService userService;
    private final IBuildingService buildingService;
    private final IApartmentDebtsService apartmentDebtService;
    private final JwtTokenService jwtTokenService;
    private final DebtMapper debtMapper;
    private final IAnnouncementService announcementService;
    private final IDueService dueService;
    private final ApartmentDebtsBaseService apartmentDebtsBaseService;
    private final ApartmentDebtsMapper apartmentDebtsMapper;

    public DebtServiceImpl(
            DebtRepository debtRepository,
            JwtTokenService jwtTokenService,
            IUserService userService,
            IBuildingService buildingService,
            IApartmentDebtsService apartmentDebtService,
            DebtMapper debtMapper, IAnnouncementService announcementService, IDueService dueService,
            ApartmentDebtsBaseService apartmentDebtsBaseService, ApartmentDebtsMapper apartmentDebtsMapper) {
        this.debtRepository = debtRepository;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.buildingService = buildingService;
        this.apartmentDebtService = apartmentDebtService;
        this.debtMapper = debtMapper;
        this.announcementService = announcementService;
        this.dueService = dueService;
        this.apartmentDebtsBaseService = apartmentDebtsBaseService;
        this.apartmentDebtsMapper = apartmentDebtsMapper;
    }


    @Override
    @Transactional
    public void createDueDebt(Due due) {
        Debt debt = debtMapper.dtoToEntity(
                new DtoDebtIU(
                        "Due Payment for " + due.getDayOfMonth() + " of the month",
                        due.getDueAmount(),
                        DebtType.DUES.name(),
                        due.getBuilding().getId(),
                        due.getBuilding().getApartments().stream()
                                .map(Apartment::getId)
                                .collect(Collectors.toSet())
                )
        );

        Debt savedDebt = debtRepository.save(debt);
        createAnnouncementForDebt(savedDebt, "Due Payment Created",
                "A new due payment has been created for the building: " + due.getBuilding().getName() + ".\n" +
                        "Due Date: " + due.getDayOfMonth() + "\n" +
                        "Amount: " + due.getDueAmount() + "\n" +
                        "Type: " + DebtType.DUES.name(),
                "system", due.getBuilding());

    }

    private void createAnnouncementForDebt(Debt debt, String title, String description, String createdBy, Building building) {
        announcementService.createAnnouncement(title,
                description,
                createdBy,
                building.getId(),
                debt.getApartmentDebts().stream()
                        .map(apartmentDebt -> apartmentDebt.getApartmentAccount().getApartment().getId())
                        .collect(Collectors.toList()));

    }

    @Override
    @Transactional
    public DtoDebt createDebt(String token, DtoDebtIU dtoDebtIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoDebtIU.getBuildingId());
        Building building = buildingService.getBuildingById(dtoDebtIU.getBuildingId());

        checkApartmentsAreInBuilding(building, dtoDebtIU.getApartmentIds());

        Debt debt = debtRepository.save(debtMapper.dtoToEntity(dtoDebtIU));
        apartmentDebtService.setDebtToApartments(debt, building, new ArrayList<>(dtoDebtIU.getApartmentIds()));

        createAnnouncementForDebt(debt, "Debt Created",
                "A new debt has been created for the building: " + building.getName() + ".\n" +
                        "Description: " + dtoDebtIU.getDescription() + "\n" +
                        "Amount: " + dtoDebtIU.getAmount() + "\n" +
                        "Type: " + dtoDebtIU.getType(),
                "manager", building);

        return debtMapper.entityToDto(debt);
    }

    private void checkApartmentsAreInBuilding(Building building, Set<Long> apartmentIds) {
        if (!building.getApartments().stream().map(Apartment::getId).collect(Collectors.toSet()).containsAll(apartmentIds))
            throw new ApplicationException(new ErrorMessage(MessageType.ERROR, "Some of the apartment IDs provided do not belong to the building."));
    }

    @Override
    @Transactional
    public DtoDebt updateDebt(String token, Long debtId, DtoDebtIU dtoDebtIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoDebtIU.getBuildingId());
        Debt debt = debtRepository.findById(debtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Debt not found.")));
        if (debt.getApartmentDebts().stream().anyMatch(ApartmentDebts::isPaid)) {
            throw new ApplicationException(new ErrorMessage(MessageType.ERROR, "Cannot update a debt that has already been paid."));
        }

        checkApartmentsAreInBuilding(buildingService.getBuildingById(dtoDebtIU.getBuildingId()), dtoDebtIU.getApartmentIds());

        debt.setAmount(dtoDebtIU.getAmount());
        debt.setDescription(dtoDebtIU.getDescription());
        debt.setType(DebtType.valueOf(dtoDebtIU.getType()));
        debt.setUpdatedAt(LocalDateTime.now());

        Debt updatedDebt = debtRepository.save(debt);

        if (!debt.getApartmentDebts().stream().map(apartmentdebts -> apartmentdebts.getApartmentAccount().getApartment().getId())
                .collect(Collectors.toSet()).containsAll(dtoDebtIU.getApartmentIds())) {
            apartmentDebtService.updateApartmentDebts(updatedDebt, buildingService.getBuildingById(updatedDebt.getBuildingId()), new ArrayList<>(dtoDebtIU.getApartmentIds()));
        }

        announcementService.createAnnouncement("Debt Updated",
                "A debt has been updated for the building: " + buildingService.getBuildingById(updatedDebt.getBuildingId()).getName() + ".\n" +
                        "Description: " + dtoDebtIU.getDescription() + "\n" +
                        "Amount: " + dtoDebtIU.getAmount() + "\n" +
                        "Type: " + dtoDebtIU.getType(),
                "system",
                updatedDebt.getBuildingId(),
                new ArrayList<>(dtoDebtIU.getApartmentIds()));

        return debtMapper.entityToDto(updatedDebt);
    }

    @Override
    public DtoDebt getDebtById(String token, Long debtId) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), debtId);
        return debtMapper.entityToDto(debtRepository.findById(debtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Debt not found.")))
        );
    }

    @Override
    @Transactional
    public String deleteDebt(String token, Long debtId) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), debtId);
        Debt debt = debtRepository.findById(debtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Debt not found.")));
        if (debt.getApartmentDebts().stream().anyMatch(ApartmentDebts::isPaid)) {
            throw new ApplicationException(new ErrorMessage(MessageType.ERROR, "Cannot delete a debt that has already been paid."));
        }
        debtRepository.delete(debt);
        return "Debt deleted successfully.";
    }

    @Override
    public Page<DtoApartmentDebts> getApartmentDebtsByDebtIdAndFilter(Long debtId, Boolean isPaid, Boolean isConfirm, int page, int pageSize, String sortBy, String sortDirection, String token) {
        Debt debt = debtRepository.findById(debtId).orElseThrow(() ->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Debt not found.")));
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), debt.getBuildingId());

        return apartmentDebtsBaseService
                .getApartmentDebtsByDebtId(debtId, isPaid, isConfirm, page, pageSize, sortBy, sortDirection)
                .map(apartmentDebtsMapper::entityToDto);
    }


    @Scheduled(cron = "0 0 1 * * ?") // Every day at 01:00 AM
    @Transactional
    protected void createDuesForAllBuildings() {
        List<Due> dueList = dueService.findAllByDayOfMonth();
        if (!dueList.isEmpty()) {
            for (Due due : dueList) {
                createDueDebt(due);
            }
        }
    }
}
