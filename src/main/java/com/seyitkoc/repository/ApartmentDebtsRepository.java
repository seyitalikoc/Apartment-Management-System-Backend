package com.seyitkoc.repository;

import com.seyitkoc.entity.ApartmentDebts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ApartmentDebtsRepository extends JpaRepository<ApartmentDebts, Long>, JpaSpecificationExecutor<ApartmentDebts> {
}
