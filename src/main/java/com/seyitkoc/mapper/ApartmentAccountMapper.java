package com.seyitkoc.mapper;

import com.seyitkoc.entity.ApartmentAccount;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import org.springframework.stereotype.Component;

@Component
public class ApartmentAccountMapper {

    public DtoApartmentAccount toDto(ApartmentAccount apartmentAccount) {
        if (apartmentAccount == null) {
            return null;
        }

        return DtoApartmentAccount.builder()
                .id(apartmentAccount.getId())
                .balance(apartmentAccount.getBalanceCalculated())
                .apartmentId(apartmentAccount.getApartment().getId())
                .apartmentNumber(apartmentAccount.getApartment().getApartmentNumber())
                .build();
    }
}
