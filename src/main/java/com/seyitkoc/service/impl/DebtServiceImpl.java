package com.seyitkoc.service.impl;

import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import com.seyitkoc.entity.apartment.Apartment;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.debt.ApartmentDebts;
import com.seyitkoc.entity.debt.Debt;
import com.seyitkoc.enums.DebtType;
import com.seyitkoc.exception.ApplicationException;
import com.seyitkoc.exception.ErrorMessage;
import com.seyitkoc.exception.MessageType;
import com.seyitkoc.mapper.DebtMapper;
import com.seyitkoc.repository.DebtRepository;
import com.seyitkoc.security.JwtTokenService;
import com.seyitkoc.service.IApartmentDebtService;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.service.IDebtService;
import com.seyitkoc.service.IUserService;
import com.seyitkoc.specification.DebtSpecification;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DebtServiceImpl implements IDebtService {
    private final DebtRepository debtRepository;
    private final IUserService userService;
    private final IBuildingService buildingService;
    private final IApartmentDebtService apartmentDebtService;
    private final JwtTokenService jwtTokenService;
    private final DebtMapper debtMapper;

    public DebtServiceImpl(
            DebtRepository debtRepository,
            JwtTokenService jwtTokenService,
            IUserService userService,
            IBuildingService buildingService,
            IApartmentDebtService apartmentDebtService,
            DebtMapper debtMapper
    ) {
        this.debtRepository = debtRepository;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.buildingService = buildingService;
        this.apartmentDebtService = apartmentDebtService;
        this.debtMapper = debtMapper;
    }


    @Override
    @Transactional
    public DtoDebt createDebt(String token, DtoDebtIU dtoDebtIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoDebtIU.getBuildingId());
        Building building = buildingService.getBuildingById(dtoDebtIU.getBuildingId());

        checkApartmentsAreInBuilding(building, dtoDebtIU.getApartmentIds());

        Debt debt = debtRepository.save(debtMapper.dtoToEntity(dtoDebtIU));
        apartmentDebtService.setDebtToApartments(debt, building, new ArrayList<>(dtoDebtIU.getApartmentIds()));
        // create an announcement for the debt
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


        return debtMapper.entityToDto(updatedDebt);
    }

    @Override
    public Page<DtoDebt> getAllDebtsByBuildingId(Long buildingId, String type, String searchingText,
                                                 Double minAmount, Double maxAmount,
                                                 LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
                                                 int page, int size, String sortBy, String sortDirection,
                                                 String token
    ) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token), buildingId);
        Specification<Debt> specification = Specification.where(DebtSpecification.hasBuildingId(buildingId))
                .and(DebtSpecification.hasType(type))
                .and(DebtSpecification.descriptionHasText(searchingText))
                .and(DebtSpecification.hasMinAmount(minAmount))
                .and(DebtSpecification.hasMaxAmount(maxAmount))
                .and(DebtSpecification.hasMinCreatedAt(minCreatedAt))
                .and(DebtSpecification.hasMaxCreatedAt(maxCreatedAt));

        return debtRepository.findAll(specification, PageRequest.of(page, size, Sort.by(sortDirection, sortBy)))
                .map(debtMapper::entityToDto);
    }

    @Override
    public Page<DtoDebt> getAllDebtsByApartmentId(Long buildingId, Long apartmentId, String type, String searchingText, Double minAmount, Double maxAmount, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, int page, int size, String sortBy, String sortDirection, String token) {
        try {
            userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingId);
        } catch (ApplicationException e) {
            try {
                userService.checkUserIsOwnerOrTenantOfApartment(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), apartmentId);
            } catch (ApplicationException ex) {
                throw new ApplicationException(new ErrorMessage(MessageType.ERROR, "You are not authorized to view this debt."));
            }
        }
        Specification<Debt> specification = Specification.where(DebtSpecification.hasBuildingId(buildingId))
                .and(DebtSpecification.hasApartmentId(apartmentId))
                .and(DebtSpecification.hasType(type))
                .and(DebtSpecification.descriptionHasText(searchingText))
                .and(DebtSpecification.hasMinAmount(minAmount))
                .and(DebtSpecification.hasMaxAmount(maxAmount))
                .and(DebtSpecification.hasMinCreatedAt(minCreatedAt))
                .and(DebtSpecification.hasMaxCreatedAt(maxCreatedAt));

        return debtRepository.findAll(
                        specification,
                        PageRequest.of(page, size, Sort.by(sortDirection, sortBy))
                )
                .map(debt -> {
                    debt.getApartmentDebts().removeIf(apartmentDebt ->
                            !apartmentDebt.getApartmentAccount().getApartment().getId().equals(apartmentId)
                    );
                    return debtMapper.entityToDto(debt);
                });
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

}
