package com.seyitkoc.service.impl;

import com.seyitkoc.service.IApartmentDebtsService;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.ApartmentDebts;
import com.seyitkoc.mapper.ApartmentDebtsMapper;
import com.seyitkoc.repository.ApartmentDebtsRepository;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.entity.Building;
import com.seyitkoc.entity.Debt;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApartmentDebtsServiceImpl implements IApartmentDebtsService {
    private final ApartmentDebtsRepository apartmentDebtRepository;
    private final JwtTokenService jwtTokenService;
    private final IUserService userService;
    private final ApartmentDebtsMapper apartmentDebtsMapper;

    public ApartmentDebtsServiceImpl(ApartmentDebtsRepository apartmentDebtRepository, JwtTokenService jwtTokenService, IUserService userService, ApartmentDebtsMapper apartmentDebtsMapper) {
        this.apartmentDebtRepository = apartmentDebtRepository;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.apartmentDebtsMapper = apartmentDebtsMapper;
    }


    @Override
    @Transactional
    public void setDebtToApartments(Debt debt, Building building, List<Long> apartmentIds) {
        List<ApartmentDebts> apartmentDebtsList = apartmentIds.stream()
                .map(apartmentId -> ApartmentDebts.builder()
                        .apartmentAccount(building.getApartments().stream()
                                .filter(apartment -> apartment.getId().equals(apartmentId))
                                .findFirst().orElseThrow(() -> new RuntimeException("Apartment not found: id=" + apartmentId)).getAccount()
                        )
                        .debt(debt)
                        .paidAt(null)
                        .confirmedAt(null)
                        .build()
                ).toList();
        apartmentDebtRepository.saveAll(apartmentDebtsList);
    }

    @Override
    @Transactional
    public void updateApartmentDebts(Debt debt, Building building, List<Long> newApartmentIds) {
        // remove ApartmentDebts that are not in the new list
        debt.getApartmentDebts().removeIf(apartmentDebt ->
                !newApartmentIds.contains(apartmentDebt.getApartmentAccount().getApartment().getId())
        );

        // find existing ApartmentDebts for the new apartment IDs
        Set<Long> existingApartmentIds = debt.getApartmentDebts().stream()
                .map(ad -> ad.getApartmentAccount().getApartment().getId())
                .collect(Collectors.toSet());

        List<ApartmentDebts> newApartmentDebts = newApartmentIds.stream()
                .filter(id -> !existingApartmentIds.contains(id))
                .map(id -> {
                    Apartment matchingApartment = building.getApartments().stream()
                            .filter(apartment -> apartment.getId().equals(id))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Apartment not found: id=" + id));

                    return ApartmentDebts.builder()
                            .apartmentAccount(matchingApartment.getAccount())
                            .debt(debt)
                            .paidAt(null)
                            .confirmedAt(null)
                            .build();
                })
                .toList();

        debt.getApartmentDebts().addAll(newApartmentDebts);
        apartmentDebtRepository.saveAll(debt.getApartmentDebts());
    }


    @Override
    @Transactional
    public String paidDebt(String token, Long apartmentDebtId) {
        ApartmentDebts apartmentDebt = apartmentDebtRepository.findById(apartmentDebtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment debt not found.")));

        userService.checkUserIsOwnerOrTenantOfApartment(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")),
                apartmentDebt.getApartmentAccount().getApartment().getId());

        if (apartmentDebt.isPaid()) {
            throw new ApplicationException(new ErrorMessage(MessageType.BAD_REQUEST, "This debt is already paid."));
        }
        apartmentDebt.setPaidAt(LocalDateTime.now());
        apartmentDebt.setPaid(true);
        ApartmentDebts savedApartmentDebt = apartmentDebtRepository.save(apartmentDebt);
        return savedApartmentDebt.isPaid() ? "Debt paid successfully." : "Debt payment failed.";
    }

    @Override
    @Transactional
    public String confirmDebtPayment(Long apartmentDebtId, String token) {
        ApartmentDebts apartmentDebt = apartmentDebtRepository.findById(apartmentDebtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment debt not found.")));
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")),
                apartmentDebt.getApartmentAccount().getApartment().getBuilding().getId());

        if (apartmentDebt.isConfirmed()) {
            throw new ApplicationException(new ErrorMessage(MessageType.BAD_REQUEST, "This debt payment is already confirmed."));
        }
        apartmentDebt.setConfirmedAt(LocalDateTime.now());
        apartmentDebt.setConfirmed(true);
        ApartmentDebts savedApartmentDebt = apartmentDebtRepository.save(apartmentDebt);
        return savedApartmentDebt.isConfirmed() ? "Debt payment confirmed successfully." : "Debt payment confirmation failed.";
    }

    @Override
    public DtoApartmentDebts getApartmentDebtByFilter(Long id, String token) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        ApartmentDebts apartmentDebt = apartmentDebtRepository.getReferenceById(id);
        try{
            userService.checkUserIsOwnerOrTenantOfApartment(email, apartmentDebt.getApartmentAccount().getApartment().getId());
        }catch (ApplicationException e){
            userService.checkUserIsManagerOfBuilding(email, apartmentDebt.getApartmentAccount().getApartment().getBuilding().getId());
        }
        return apartmentDebtsMapper.entityToDto(apartmentDebt);
    }
}
