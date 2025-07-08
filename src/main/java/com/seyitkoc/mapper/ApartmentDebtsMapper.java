package com.seyitkoc.mapper;

import com.seyitkoc.entity.ApartmentDebts;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApartmentDebtsMapper {
    public DtoApartmentDebts entityToDto(ApartmentDebts apartmentDebts) {
        if (apartmentDebts == null) {
            return null;
        }
        return DtoApartmentDebts.builder()
                .id(apartmentDebts.getId())
                .apartmentId(apartmentDebts.getApartmentAccount().getApartment() != null ? apartmentDebts.getApartmentAccount().getApartment().getId() : null)
                .debtId(apartmentDebts.getDebt() != null ? apartmentDebts.getDebt().getId() : null)
                .isPaid(apartmentDebts.isPaid())
                .paidAt(apartmentDebts.getPaidAt() != null ? apartmentDebts.getPaidAt().toString() : null)
                .isConfirmed(apartmentDebts.isConfirmed())
                .confirmedAt(apartmentDebts.getConfirmedAt() != null ? apartmentDebts.getConfirmedAt().toString() : null)
                .build();
    }

    public List<DtoApartmentDebts> entitiesToDtos(List<ApartmentDebts> apartmentDebtsList) {
        if (apartmentDebtsList == null || apartmentDebtsList.isEmpty()) {
            return List.of();
        }
        return apartmentDebtsList.stream()
                .map(this::entityToDto)
                .toList();
    }
}
