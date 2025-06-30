package com.seyitkoc.repository;

import com.seyitkoc.entity.building.BuildingAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingAccountRepository extends JpaRepository<BuildingAccount, Long> {
    Page<BuildingAccount> findAllByBuildingId(Long buildingId, Pageable pageable);
}
