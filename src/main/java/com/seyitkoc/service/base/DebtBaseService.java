package com.seyitkoc.service.base;

import com.seyitkoc.entity.Debt;
import com.seyitkoc.repository.DebtRepository;
import com.seyitkoc.specification.DebtSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DebtBaseService {
    private final DebtRepository debtRepository;
    private final DebtSpecification debtSpecification;

    public DebtBaseService(DebtRepository debtRepository, DebtSpecification debtSpecification) {
        this.debtRepository = debtRepository;
        this.debtSpecification = debtSpecification;
    }

    public Page<Debt> getAllDebtsByBuildingIdAndFilter(
            Long buildingId, String text, String type, Double minAmount, Double maxAmount,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            int page, int pageSize, String sortBy, String sortDirection
    ){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<Debt> specification = Specification.where(debtSpecification.hasBuildingId(buildingId))
                .and(debtSpecification.descriptionHasText(text))
                .and(debtSpecification.hasType(type))
                .and(debtSpecification.hasMinAmount(minAmount))
                .and(debtSpecification.hasMaxAmount(maxAmount))
                .and(debtSpecification.hasMinCreatedAt(minCreatedAt))
                .and(debtSpecification.hasMaxCreatedAt(maxCreatedAt));

        return  debtRepository.findAll(specification, pageRequest);
    }

    public Page<Debt> getAllDebtsByApartmentIdAndFilter(
            Long apartmentId, String text, String type, Double minAmount, Double maxAmount,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            int page, int pageSize, String sortBy, String sortDirection
    ){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<Debt> specification = Specification.where(debtSpecification.hasApartmentId(apartmentId))
                .and(debtSpecification.descriptionHasText(text))
                .and(debtSpecification.hasType(type))
                .and(debtSpecification.hasMinAmount(minAmount))
                .and(debtSpecification.hasMaxAmount(maxAmount))
                .and(debtSpecification.hasMinCreatedAt(minCreatedAt))
                .and(debtSpecification.hasMaxCreatedAt(maxCreatedAt));

        return  debtRepository.findAll(specification, pageRequest);
    }
}
