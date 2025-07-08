package com.seyitkoc.repository;

import com.seyitkoc.entity.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    Page<Building> findAllByManager_Id(Long managerId, Pageable pageable);
}
