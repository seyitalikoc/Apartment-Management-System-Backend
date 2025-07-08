package com.seyitkoc.mapper;

import com.seyitkoc.entity.Apartment;
import com.seyitkoc.dto.apartment.DtoApartment;
import org.springframework.stereotype.Component;

@Component
public class ApartmentMapper {

    public DtoApartment toDtoApartment(Apartment apartment){
        if (apartment == null)
            return null;

        return  DtoApartment.builder()
                .id(apartment.getId())
                .apartmentNumber(apartment.getApartmentNumber())
                .apartmentFloor(apartment.getApartmentFloor())
                .buildingId(apartment.getBuilding() != null ? apartment.getBuilding().getId() : null)
                .ownerId(apartment.getOwner() != null ? apartment.getOwner().getId() : null)
                .tenantId(apartment.getTenant() != null ? apartment.getTenant().getId() : null)
                .accountId(apartment.getAccount() != null ? apartment.getAccount().getId() : null)
                .createdAt(apartment.getCreatedAt().toString())
                .updatedAt(apartment.getUpdatedAt().toString())
                .build();
    }
}
