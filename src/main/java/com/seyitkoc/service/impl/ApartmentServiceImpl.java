package com.seyitkoc.service.impl;

import com.seyitkoc.service.base.AnnouncementBaseService;
import com.seyitkoc.mapper.AnnouncementMapper;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.mapper.ApartmentMapper;
import com.seyitkoc.repository.ApartmentRepository;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.mapper.ApartmentAccountMapper;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Building;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IApartmentAccountService;
import com.seyitkoc.service.base.DebtBaseService;
import com.seyitkoc.mapper.DebtMapper;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements IApartmentService {
    private final JwtTokenService jwtTokenService;
    private final IUserService userService;

    private final ApartmentRepository apartmentRepository;
    private final IApartmentAccountService apartmentAccountService;
    private final ApartmentMapper apartmentMapper;

    private final AnnouncementBaseService announcementBaseService;
    private final DebtBaseService debtBaseService;
    private final AnnouncementMapper announcementMapper;
    private final ApartmentAccountMapper apartmentAccountMapper;
    private final DebtMapper debtMapper;

    public ApartmentServiceImpl(JwtTokenService jwtTokenService, IUserService userService, ApartmentRepository apartmentRepository, IApartmentAccountService apartmentAccountService, ApartmentMapper apartmentMapper, AnnouncementBaseService announcementBaseService, DebtBaseService debtBaseService, AnnouncementMapper announcementMapper, ApartmentAccountMapper apartmentAccountMapper, DebtMapper debtMapper) {
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.apartmentRepository = apartmentRepository;
        this.apartmentAccountService = apartmentAccountService;
        this.apartmentMapper = apartmentMapper;
        this.announcementBaseService = announcementBaseService;
        this.debtBaseService = debtBaseService;
        this.announcementMapper = announcementMapper;
        this.apartmentAccountMapper = apartmentAccountMapper;
        this.debtMapper = debtMapper;
    }

    @Transactional
    @Override
    public void createApartmentsForBuilding(Building building, Long apartmentCount) {
        List<Apartment> apartmentsForAccountCreation = new ArrayList<>();

        if (!building.getApartments().isEmpty()) {
            if (building.getApartments().size() > apartmentCount) {
                List<Apartment> apartmentsToRemove = building.getApartments().stream()
                        .filter(apartment -> apartment.getApartmentNumber() > apartmentCount)
                        .toList();
                building.getApartments().removeAll(apartmentsToRemove);
            }
            if (building.getApartments().size() < apartmentCount) {
                for (int i = building.getApartments().size() + 1; i <= apartmentCount; i++) {
                    Apartment newApartment = createApartment(building, (long) i);
                    building.getApartments().add(newApartment);
                    apartmentsForAccountCreation.add(newApartment);
                }
                apartmentRepository.saveAll(apartmentsForAccountCreation);
                createAccounts(apartmentsForAccountCreation);
            }
        } else {
            for (int i = 1; i <= apartmentCount; i++) {
                Apartment newApartment = createApartment(building, (long) i);
                building.getApartments().add(newApartment);
                apartmentsForAccountCreation.add(newApartment);
            }
            apartmentRepository.saveAll(apartmentsForAccountCreation);
            createAccounts(apartmentsForAccountCreation);
        }
    }
    private Apartment createApartment(Building building, Long apartmentNumber) {
        Apartment apartment = new Apartment();
        apartment.setApartmentNumber(apartmentNumber);
        apartment.setBuilding(building);
        return apartment;
    }
    private void createAccounts(List<Apartment> apartments) {
        apartmentAccountService.createAccounts(apartments);
    }

    @Override
    public Apartment getApartmentById(Long apartmentId) {
        return apartmentRepository.findApartmentById(apartmentId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment not found with id: " + apartmentId)));
    }


    // Read Operation
    @Override
    public DtoApartment getApartmentById(String token, Long apartmentId) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        Apartment apartment = apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found"));

        userService.checkUserIsMemberOfBuilding(email, apartment.getBuilding().getId());
        return apartmentMapper.toDtoApartment(apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found")));
    }


    // Nested Resources (Sub-resources)
    @Override
    public DtoApartmentAccount getAccountByApartmentId(String token, Long apartmentId) {
        Apartment apartment = getApartmentById(apartmentId);
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        try {
            userService.checkUserIsMemberOfBuilding(email, apartment.getBuilding().getId());
        }catch(ApplicationException e){
            userService.checkUserIsOwnerOrTenantOfApartment(email, apartmentId);
        }

        return apartmentAccountMapper.toDto(apartment.getAccount());
    }

    @Override
    public Page<DtoAnnouncement> getAllAnnouncementsByApartmentIdAndFilter(Long apartmentId, String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, String createdBy, Boolean isRead, int page, int size, String sortBy, String sortDirection, String token) {
        Apartment apartment = getApartmentById(apartmentId);
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        try {
            userService.checkUserIsMemberOfBuilding(email, apartment.getBuilding().getId());
        }catch(ApplicationException e){
            userService.checkUserIsOwnerOrTenantOfApartment(email, apartmentId);
        }

        return announcementBaseService.findAnnouncementsByApartmentIdWithFilters(apartmentId, text,
                        minCreatedAt, maxCreatedAt, createdBy, isRead, page, size, sortBy, sortDirection)
                .map(announcementMapper::toDtoAnnouncement);
    }

    @Override
    public Page<DtoDebt> getAllDebtsByApartmentIdAndFilter(Long apartmentId, String text, String type, Double minAmount, Double maxAmount, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, int page, int size, String sortBy, String sortDirection, String token) {
        userService.checkUserIsOwnerOrTenantOfApartment(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ","")), apartmentId);

        return debtBaseService
                .getAllDebtsByApartmentIdAndFilter(apartmentId, text, type, minAmount, maxAmount,
                        minCreatedAt, maxCreatedAt, page, size, sortBy, sortDirection)
                .map(debtMapper::entityToDto);
    }


    // Special Operations
    @Override
    @Transactional
    public DtoApartment setApartmentOwner(String token, Long apartmentId, Long userId) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        Apartment apartment = apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found"));
        if (apartment.getOwner() != null) {
            userService.checkUserIsOwnerOfApartment(email, apartmentId);
            if (apartment.getOwner().getId().equals(userId)) {
                throw new ApplicationException(new ErrorMessage(MessageType.BAD_REQUEST, "This user is already the owner of this apartment."));
            }
            apartment.setOwner(userService.getUserById(userId));
        } else {
            apartment.setOwner(userService.getUserById(userId));
        }
        return apartmentMapper.toDtoApartment(apartmentRepository.save(apartment));
    }

    @Override
    @Transactional
    public DtoApartment setApartmentTenant(String token, Long apartmentId, Long userId) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        Apartment apartment = apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found"));
        if (apartment.getOwner() != null) {
            userService.checkUserIsOwnerOfApartment(email, apartmentId);
            if (apartment.getTenant() != null && apartment.getTenant().getId().equals(userId)) {
                throw new ApplicationException(new ErrorMessage(MessageType.BAD_REQUEST, "This user is already the tenant of this apartment."));
            }
            apartment.setTenant(userService.getUserById(userId));
        }
        return apartmentMapper.toDtoApartment(apartmentRepository.save(apartment));
    }
}
