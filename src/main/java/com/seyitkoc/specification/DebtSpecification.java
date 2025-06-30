package com.seyitkoc.specification;

import com.seyitkoc.entity.debt.Debt;
import com.seyitkoc.enums.DebtType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class DebtSpecification {

    public static Specification<Debt> hasBuildingId(Long buildingId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("building").get("id"), buildingId);
        });
    }

    public static Specification<Debt> hasApartmentId(Long apartmentId) {
        return ((root, query, criteriaBuilder) -> {
            if (apartmentId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("apartmentAccount").get("apartment").get("id"), apartmentId);
        });
    }

    public static Specification<Debt> hasType(String type) {
        return (root, query, criteriaBuilder) -> {
            if (type == null || type.isBlank()) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("type"), DebtType.valueOf(type));
        };
    }

    public static Specification<Debt> descriptionHasText(String text) {
        return ((root, query, criteriaBuilder) -> {
            if (text == null || text.isBlank()) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + text.toLowerCase() + "%");
        });
    }

    public static Specification<Debt> hasMinAmount(Double minAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (minAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), minAmount);
        });
    }

    public static Specification<Debt> hasMaxAmount(Double maxAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (maxAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("amount"), maxAmount);
        });
    }

    public static Specification<Debt> hasMinCreatedAt(LocalDateTime minCreatedAt) {
        return ((root, query, criteriaBuilder) -> {
            if (minCreatedAt == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
        });
    }

    public static Specification<Debt> hasMaxCreatedAt(LocalDateTime maxCreatedAt) {
        return ((root, query, criteriaBuilder) -> {
            if (maxCreatedAt == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
        });
    }
}
