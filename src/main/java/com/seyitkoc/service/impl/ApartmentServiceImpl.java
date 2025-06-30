package com.seyitkoc.service.impl;

import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.entity.apartment.Apartment;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.exception.ApplicationException;
import com.seyitkoc.exception.ErrorMessage;
import com.seyitkoc.exception.MessageType;
import com.seyitkoc.mapper.ApartmentMapper;
import com.seyitkoc.repository.ApartmentRepository;
import com.seyitkoc.security.JwtTokenService;
import com.seyitkoc.service.IApartmentAccountService;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements IApartmentService {
    private final JwtTokenService jwtTokenService;
    private final IUserService userService;

    private final ApartmentRepository apartmentRepository;
    private final IApartmentAccountService apartmentAccountService;
    private final ApartmentMapper apartmentMapper;

    public ApartmentServiceImpl(JwtTokenService jwtTokenService, IUserService userService, ApartmentRepository apartmentRepository, IApartmentAccountService apartmentAccountService, ApartmentMapper apartmentMapper) {
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.apartmentRepository = apartmentRepository;
        this.apartmentAccountService = apartmentAccountService;
        this.apartmentMapper = apartmentMapper;
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
        apartments.forEach(apartmentAccountService::createAccount);
    }


    @Override
    public DtoApartment getApartmentById(String token, Long apartmentId) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        Apartment apartment = apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found"));

        userService.checkUserIsMemberOfBuilding(email, apartment.getBuilding().getId());
        return apartmentMapper.toDtoApartment(apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found")));
    }

    @Override
    public Page<DtoApartment> getAllApartmentsByBuildingId(String token, Long buildingId, int page, int size, String sortBy, String sortDirection) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));

        userService.checkUserIsMemberOfBuilding(email, buildingId);
        return apartmentRepository.findAllByBuildingId(buildingId, PageRequest.of(page, size, Sort.by(sortBy, sortDirection))).map(apartmentMapper::toDtoApartment);
    }

    @Override
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
