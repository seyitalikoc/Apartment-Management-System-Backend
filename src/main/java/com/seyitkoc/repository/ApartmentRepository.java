package com.seyitkoc.repository;

import com.seyitkoc.entity.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    Optional<Apartment> findApartmentById(Long apartmentId);
    Page<Apartment> findAllByBuildingId(Long buildingId, Pageable pageable);

    Page<Apartment> findAllByOwner_Id(Long ownerId, Pageable pageable);

    Apartment findApartmentByTenant_Id(Long tenantId);
}
