package com.seyitkoc.service.base;

import com.seyitkoc.repository.TransactionRepository;
import com.seyitkoc.specification.TransactionSpecification;
import com.seyitkoc.entity.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TransactionBaseService {
    private final TransactionRepository transactionRepository;
    private final TransactionSpecification transactionSpecification;

    public TransactionBaseService(TransactionRepository transactionRepository, TransactionSpecification transactionSpecification) {
        this.transactionRepository = transactionRepository;
        this.transactionSpecification = transactionSpecification;
    }

    public Page<Transaction> getTransactionsByBuildingIdAndFilter(
            Long buildingId, String type, String subType, String text, Double minAmount, Double maxAmount,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection) {

        Specification<Transaction> specification = Specification.where(transactionSpecification.hasBuildingId(buildingId))
                .and(transactionSpecification.byType(type))
                .and(transactionSpecification.bySubType(type, subType))
                .and(transactionSpecification.descriptionHasText(text))
                .and(transactionSpecification.hasMinAmount(minAmount))
                .and(transactionSpecification.hasMaxAmount(maxAmount))
                .and(transactionSpecification.hasStartDate(startDate))
                .and(transactionSpecification.hasEndDate(endDate));

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return transactionRepository.findAll(specification, pageRequest);
    }

    public Page<Transaction> getTransactionsByBuildingAccountIdAndFilter(
            Long accountId, String type, String subType, String text, Double minAmount, Double maxAmount,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection) {

        Specification<Transaction> specification = Specification.where(transactionSpecification.hasBuildingAccountId(accountId))
                .and(transactionSpecification.byType(type))
                .and(transactionSpecification.bySubType(type, subType))
                .and(transactionSpecification.descriptionHasText(text))
                .and(transactionSpecification.hasMinAmount(minAmount))
                .and(transactionSpecification.hasMaxAmount(maxAmount))
                .and(transactionSpecification.hasStartDate(startDate))
                .and(transactionSpecification.hasEndDate(endDate));

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return transactionRepository.findAll(specification, pageRequest);
    }
}
