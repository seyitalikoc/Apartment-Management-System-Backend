package com.seyitkoc.service.impl;

import com.seyitkoc.entity.apartment.Apartment;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.debt.ApartmentDebts;
import com.seyitkoc.entity.debt.Debt;
import com.seyitkoc.exception.ApplicationException;
import com.seyitkoc.exception.ErrorMessage;
import com.seyitkoc.exception.MessageType;
import com.seyitkoc.repository.ApartmentDebtRepository;
import com.seyitkoc.security.JwtTokenService;
import com.seyitkoc.service.IApartmentDebtService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApartmentDebtServiceImpl implements IApartmentDebtService {
    private final ApartmentDebtRepository apartmentDebtRepository;
    private final JwtTokenService jwtTokenService;
    private final IUserService userService;

    public ApartmentDebtServiceImpl(ApartmentDebtRepository apartmentDebtRepository, JwtTokenService jwtTokenService, IUserService userService) {
        this.apartmentDebtRepository = apartmentDebtRepository;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
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
        apartmentDebtRepository.save(apartmentDebt);
        return "Debt paid successfully.";
    }

    @Override
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
        apartmentDebtRepository.save(apartmentDebt);
        return "Debt payment confirmed successfully.";
    }
}
