package com.seyitkoc.mapper;

import com.seyitkoc.dto.apartment.account.DtoApartmentAccount;
import com.seyitkoc.entity.apartment.ApartmentAccount;
import org.springframework.stereotype.Component;

@Component
public class ApartmentAccountMapper {

    public DtoApartmentAccount toDto(ApartmentAccount apartmentAccount) {
        if (apartmentAccount == null) {
            return null;
        }

        return DtoApartmentAccount.builder()
                .id(apartmentAccount.getId())
                .balance(apartmentAccount.getBalance())
                .apartmentId(apartmentAccount.getApartment().getId())
                .apartmentNumber(apartmentAccount.getApartment().getApartmentNumber())
                .build();
    }
}
