package com.seyitkoc.service.impl;

import com.seyitkoc.service.base.AnnouncementBaseService;
import com.seyitkoc.mapper.AnnouncementMapper;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.service.base.ApartmentBaseService;
import com.seyitkoc.mapper.ApartmentMapper;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.service.base.ApartmentAccountBaseService;
import com.seyitkoc.mapper.ApartmentAccountMapper;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.enums.AuthRole;
import com.seyitkoc.entity.Building;
import com.seyitkoc.mapper.BuildingMapper;
import com.seyitkoc.repository.BuildingRepository;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.service.base.BuildingAccountBaseService;
import com.seyitkoc.mapper.BuildingAccountMapper;
import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.service.base.DebtBaseService;
import com.seyitkoc.mapper.DebtMapper;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.service.base.DueBaseService;
import com.seyitkoc.mapper.DueMapper;
import com.seyitkoc.service.IDueService;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.service.base.PollBaseService;
import com.seyitkoc.mapper.PollMapper;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.service.base.TransactionBaseService;
import com.seyitkoc.mapper.TransactionMapper;
import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.entity.User;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements IBuildingService {
    private final BuildingRepository buildingRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final IApartmentService apartmentService;
    private final IBuildingAccountService buildingAccountService;
    private final BuildingMapper buildingMapper;
    private final IDueService dueService;
    private final ApartmentMapper apartmentMapper;
    private final AnnouncementMapper announcementMapper;
    private final BuildingAccountMapper buildingAccountMapper;
    private final PollMapper pollMapper;
    private final ApartmentBaseService apartmentBaseService;
    private final AnnouncementBaseService announcementBaseService;
    private final BuildingAccountBaseService buildingAccountBaseService;
    private final PollBaseService pollBaseService;
    private final ApartmentAccountBaseService apartmentAccountBaseService;
    private final ApartmentAccountMapper apartmentAccountMapper;
    private final DebtBaseService debtBaseService;
    private final DebtMapper debtMapper;
    private final TransactionBaseService transactionBaseService;
    private final TransactionMapper transactionMapper;
    private final DueBaseService dueBaseService;
    private final DueMapper dueMapper;

    public BuildingServiceImpl(
            BuildingRepository buildingRepository, IUserService userService,
            JwtTokenService jwtTokenService, IApartmentService apartmentService,
            IBuildingAccountService buildingAccountService, BuildingMapper buildingMapper,
            IDueService dueService, ApartmentMapper apartmentMapper,
            AnnouncementMapper announcementMapper, BuildingAccountMapper buildingAccountMapper,
            PollMapper pollMapper, ApartmentBaseService apartmentBaseService,
            AnnouncementBaseService announcementBaseService, BuildingAccountBaseService buildingAccountBaseService,
            PollBaseService pollBaseService, ApartmentAccountBaseService apartmentAccountBaseService,
            ApartmentAccountMapper apartmentAccountMapper, DebtBaseService debtBaseService, DebtMapper debtMapper, TransactionBaseService transactionBaseService, TransactionMapper transactionMapper, DueBaseService dueBaseService, DueMapper dueMapper) {
        this.buildingRepository = buildingRepository;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.apartmentService = apartmentService;
        this.buildingAccountService = buildingAccountService;
        this.buildingMapper = buildingMapper;
        this.dueService = dueService;
        this.apartmentMapper = apartmentMapper;
        this.announcementMapper = announcementMapper;
        this.buildingAccountMapper = buildingAccountMapper;
        this.pollMapper = pollMapper;
        this.apartmentBaseService = apartmentBaseService;
        this.announcementBaseService = announcementBaseService;
        this.buildingAccountBaseService = buildingAccountBaseService;
        this.pollBaseService = pollBaseService;
        this.apartmentAccountBaseService = apartmentAccountBaseService;
        this.apartmentAccountMapper = apartmentAccountMapper;
        this.debtBaseService = debtBaseService;
        this.debtMapper = debtMapper;
        this.transactionBaseService = transactionBaseService;
        this.transactionMapper = transactionMapper;
        this.dueBaseService = dueBaseService;
        this.dueMapper = dueMapper;
    }

    @Override
    public Building getBuildingById(Long buildingId) {
        return buildingRepository.findById(buildingId)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
    }

    // CRUD
    @Transactional
    @Override
    public String saveBuilding(DtoBuildingIU dtoBuildingIU) {
        Building building = buildingMapper.toBuilding(dtoBuildingIU);
        Building savedBuilding = buildingRepository.save(building);
        dueService.createDue("1", 1.0, savedBuilding);
        if (savedBuilding.getId() == null) {
            throw new IllegalArgumentException("Building could not be saved");
        }
        apartmentService.createApartmentsForBuilding(savedBuilding, dtoBuildingIU.getApartmentCount());
        buildingAccountService.createAccountsWhenBuildingCreate(savedBuilding);
        return "Building saved successfully.";
    }

    @Override
    public Page<DtoBuilding> getAllBuildings(int page, int size, String sortBy, String sortDirection) {
        return buildingRepository
                .findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)))
                .map(buildingMapper::toDtoBuilding);
    }

    @Override
    public DtoBuilding getBuildingById(String token, Long buildingId) {
        User user = userService.getUserByEmail(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")));

        if (!user.getAuth().getRole().equals(AuthRole.valueOf("ROLE_ADMIN"))) {
            userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingId);
        }
        Building building = buildingRepository.findById(buildingId).orElseThrow(() -> new IllegalArgumentException("Building not found"));
        return buildingMapper.toDtoBuilding(building);
    }

    @Transactional
    @Override
    public String updateBuilding(DtoBuildingIU dtoBuildingIU, Long id, String token) {
        try {
            userService.checkUserIsManagerOfBuilding(jwtTokenService
                    .findEmailFromToken(token.replace("Bearer ", "")), id);
        } catch (ApplicationException e) {
            throw new IllegalArgumentException("User not found or invalid token");
        }
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));

        Optional.ofNullable(dtoBuildingIU.getName())
                .filter(name -> !name.isBlank())
                .ifPresent(building::setName);

        Optional.ofNullable(dtoBuildingIU.getAddress())
                .filter(address -> !address.isBlank())
                .ifPresent(building::setAddress);

        Optional.ofNullable(dtoBuildingIU.getFloorCount())
                .filter(floorCount -> !floorCount.equals(building.getFloorCount()))
                .ifPresent(building::setFloorCount);

        Optional.ofNullable(dtoBuildingIU.getApartmentCount())
                .filter(apartmentCount -> !apartmentCount.equals(building.getApartmentCount()))
                .ifPresent(newCount -> {
                    apartmentService.createApartmentsForBuilding(building, newCount);
                    building.setApartmentCount(newCount);
                });

        buildingRepository.save(building);
        return "Building updated successfully.";
    }

    @Transactional
    @Override
    public String deleteBuilding(Long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if (building.isActive()) {
            throw new IllegalArgumentException("Building is active");
        }
        buildingRepository.delete(building);
        return "Building deleted successfully.";
    }

    // Nested Resources
    @Override
    public Page<DtoApartment> getAllApartmentsByBuildingId(
            String token, Long buildingId, int page, int size, String sortBy, String sortDirection) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return apartmentBaseService.getAllApartmentsByBuildingId(buildingId, page, size, sortBy, sortDirection)
                .map(apartmentMapper::toDtoApartment);
    }

    @Override
    public Page<DtoApartmentAccount> getAllApartmentAccountsByBuildingId(
            Long buildingId, int page, int size, String sortBy, String sortDirection, String token) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return apartmentAccountBaseService.getAccountsByBuildingId(buildingId, page, size, sortBy, sortDirection)
                .map(apartmentAccountMapper::toDto);
    }

    @Override
    public Page<DtoAnnouncement> getAnnouncementsByBuildingId(
            String token, Long buildingId, String text,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, String createdBy,
            int page, int size, String sortBy, String sortDirection
    ) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return announcementBaseService.findAnnouncementsByBuildingIdWithFilters(buildingId, text,
                        minCreatedAt, maxCreatedAt, createdBy,
                        page, size, sortBy, sortDirection)
                .map(announcementMapper::toDtoAnnouncement);
    }

    @Override
    public Page<DtoBuildingAccount> getAllBuildingAccountsByBuildingId(
            Long buildingId, int year, int page, int size, String sortBy, String sortDirection, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return buildingAccountBaseService.getAllAccountsByBuildingId(buildingId, year,
                        page, size, sortBy, sortDirection)
                .map(buildingAccountMapper::toDtoBuildingAccount);
    }

    @Override
    public Page<DtoDebt> getAllDebtsByBuildingIdAndFilter(
            Long buildingId, String text, String type, Double minAmount, Double maxAmount,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, int page, int size,
            String sortBy, String sortDirection, String token) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ","")), buildingId);

        return debtBaseService.getAllDebtsByBuildingIdAndFilter(buildingId, text, type, minAmount, maxAmount,
                minCreatedAt, maxCreatedAt, page, size, sortBy, sortDirection)
                .map(debtMapper::entityToDto);
    }

    @Override
    public Page<DtoTransaction> getAllTransactionsByBuildingIdAndFilter(
            String token, Long id, String type, String subType, Double minAmount, Double maxAmount, String text,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), id );

        return transactionBaseService
                .getTransactionsByBuildingIdAndFilter(id, type, subType, text, minAmount, maxAmount, startDate, endDate,
                        page, size, sortBy, sortDirection)
                .map(transactionMapper::toDto);
    }

    @Override
    public DtoDue getDueByBuildingId(Long buildingId, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return dueMapper.toDtoDue(dueBaseService.getDueByBuildingId(buildingId));
    }

    @Override
    public Page<DtoPoll> getAllPollsByBuildingId(
            Long buildingId, String text,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, boolean isFinished,
            int page, int size, String sortBy, String sortDirection, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return pollBaseService.getAllPollsByBuildingIdAndFilter(buildingId, text,
                        minCreatedAt, maxCreatedAt, isFinished,
                        page, size, sortBy, sortDirection)
                .map(pollMapper::pollToDtoPoll);
    }

    // Special Operations
    @Override
    @Transactional
    public String updateBuildingStatus(Long id, String status) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if (status.equals("active") && !building.isActive()) {
            building.setActive(true);
        } else if (status.equals("passive") && building.isActive()) {
            building.setActive(false);
        } else {
            throw new IllegalArgumentException("Invalid status change request");
        }
        buildingRepository.save(building);
        return "Building status updated successfully";
    }

    @Override
    @Transactional
    public DtoBuilding changeManager(Long buildingId, Long managerId) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if (building.getManager() != null && building.getManager().getId().equals(managerId)) {
            throw new IllegalArgumentException("This user is already the manager of the building.");
        }
        building.setManager(userService.getUserById(managerId));
        return buildingMapper.toDtoBuilding(buildingRepository.save(building));
    }
}
