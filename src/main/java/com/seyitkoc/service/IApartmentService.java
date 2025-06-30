package com.seyitkoc.service;

import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.entity.building.Building;
import org.springframework.data.domain.Page;

public interface IApartmentService {
    void createApartmentsForBuilding(Building building, Long apartmentCount);

    DtoApartment getApartmentById(String token, Long apartmentId);

    Page<DtoApartment> getAllApartmentsByBuildingId(String token, Long buildingId, int page, int size, String sortBy, String sortDirection);

    DtoApartment setApartmentOwner(String token, Long apartmentId, Long userId);

    DtoApartment setApartmentTenant(String token, Long apartmentId, Long userId);
}
