package com.seyitkoc.repository;

import com.seyitkoc.entity.debt.ApartmentDebts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentDebtRepository extends JpaRepository<ApartmentDebts, Long> {
}
