package com.seyitkoc.repository;

import com.seyitkoc.entity.Debt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DebtRepository extends JpaRepository<Debt, Long>, JpaSpecificationExecutor<Debt> {
    Page<Debt> findAll(Specification<Debt> specification, Pageable pageable);
}
