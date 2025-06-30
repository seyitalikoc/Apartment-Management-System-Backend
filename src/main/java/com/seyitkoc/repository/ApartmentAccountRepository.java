package com.seyitkoc.repository;

import com.seyitkoc.entity.apartment.ApartmentAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ApartmentAccountRepository extends JpaRepository<ApartmentAccount, Long> {
    Optional<ApartmentAccount> findApartmentAccountById(Long accountId);

    @Query("SELECT a FROM ApartmentAccount a WHERE a.apartment.building.id = :buildingId")
    Page<ApartmentAccount> findAllByBuildingId(Long buildingId, Pageable pageable);
}
