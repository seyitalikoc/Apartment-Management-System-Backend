package com.seyitkoc.specification;

import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.enums.ExpenseType;
import com.seyitkoc.enums.IncomeType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TransactionSpecification {

    public Specification<Transaction> byType(String type) {
        return ((root, query, criteriaBuilder) -> {
            if (type == null)
                return criteriaBuilder.conjunction();

            return criteriaBuilder.equal(root.get("type"), type.toUpperCase());
        });
    }

    public Specification<Transaction> bySubType(String type,String subType) {
        return ((root, query, criteriaBuilder) -> {
            if (subType == null || type == null)
                return criteriaBuilder.conjunction();

            if (type.equalsIgnoreCase("income"))
                return criteriaBuilder.equal(root.get("subType"), IncomeType.valueOf(type.toUpperCase()));

            if (type.equalsIgnoreCase("expense"))
                return  criteriaBuilder.equal(root.get("subType"), ExpenseType.valueOf(type.toUpperCase()));

            return  criteriaBuilder.conjunction();
        });
    }

    public Specification<Transaction> hasBuildingAccountId(Long buildingAccountId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingAccountId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("buildingAccount").get("id"), buildingAccountId);
        });
    }

    public Specification<Transaction> hasBuildingId(Long buildingId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("buildingAccount").get("building").get("id"), buildingId);
        });
    }

    public Specification<Transaction> hasMinAmount(Double minAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (minAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), minAmount);
        });
    }

    public Specification<Transaction> hasMaxAmount(Double maxAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (maxAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("amount"), maxAmount);
        });
    }

    public Specification<Transaction> descriptionHasText(String text) {
        return ((root, query, criteriaBuilder) -> {
            if (text == null || text.isBlank()) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + text.toLowerCase() + "%");
        });
    }

    public Specification<Transaction> hasStartDate(String startDate) {
        return ((root, query, criteriaBuilder) -> {
            if (startDate == null || startDate.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("transactionDate"), startDate); // "date" yerine "transactionDate"
        });
    }

    public Specification<Transaction> hasEndDate(String endDate) {
        return ((root, query, criteriaBuilder) -> {
            if (endDate == null || endDate.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("transactionDate"), endDate); // "date" yerine "transactionDate"
        });
    }
}
