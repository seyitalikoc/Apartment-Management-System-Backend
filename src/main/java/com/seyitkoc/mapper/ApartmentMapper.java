package com.seyitkoc.mapper;

import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.entity.apartment.Apartment;
import org.springframework.stereotype.Component;

@Component
public class ApartmentMapper {

    public DtoApartment toDtoApartment(Apartment apartment){
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
