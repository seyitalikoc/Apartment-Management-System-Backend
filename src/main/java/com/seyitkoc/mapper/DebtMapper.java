package com.seyitkoc.mapper;

import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import com.seyitkoc.entity.debt.Debt;
import com.seyitkoc.enums.DebtType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class DebtMapper {
    private final ApartmentDebtsMapper apartmentDebtsMapper;

    public DebtMapper(ApartmentDebtsMapper apartmentDebtsMapper) {
        this.apartmentDebtsMapper = apartmentDebtsMapper;
    }


    public Debt dtoToEntity(DtoDebtIU dtoDebtIU) {
        if (dtoDebtIU == null) {
            return null;
        }
        return Debt.builder()
                .id(null)
                .description(dtoDebtIU.getDescription())
                .amount(dtoDebtIU.getAmount())
                .type(DebtType.valueOf(dtoDebtIU.getType()))
                .buildingId(dtoDebtIU.getBuildingId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .apartmentDebts(new ArrayList<>())
                .build();
    }

    public DtoDebt entityToDto(Debt debt) {
        if (debt == null) {
            return null;
        }
        return DtoDebt.builder()
                .id(debt.getId())
                .description(debt.getDescription())
                .amount(debt.getAmount())
                .type(debt.getType().name())
                .createdAt(debt.getCreatedAt().toString())
                .updatedAt(debt.getUpdatedAt().toString())
                .buildingId(debt.getBuildingId())
                .apartmentDebts(apartmentDebtsMapper.entitiesToDtos(debt.getApartmentDebts()))
                .build();
    }

}
