package com.seyitkoc.repository;

import com.seyitkoc.entity.debt.Debt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepository extends JpaRepository<Debt, Long> {
    Page<Debt> findAll(Specification<Debt> specification, Pageable pageable);
}
