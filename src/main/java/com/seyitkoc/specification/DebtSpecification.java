package com.seyitkoc.specification;

import com.seyitkoc.entity.Debt;
import com.seyitkoc.enums.DebtType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DebtSpecification {

    public Specification<Debt> hasBuildingId(Long buildingId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("buildingId"), buildingId);
        });
    }

    public Specification<Debt> hasApartmentId(Long apartmentId) {
        return ((root, query, criteriaBuilder) -> {
            if (apartmentId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("apartmentDebts").get("apartmentAccount").get("apartment").get("id"), apartmentId);
        });
    }

    public Specification<Debt> hasType(String type) {
        return (root, query, criteriaBuilder) -> {
            if (type == null || type.isBlank()) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("type"), DebtType.valueOf(type));
        };
    }

    public Specification<Debt> descriptionHasText(String text) {
        return ((root, query, criteriaBuilder) -> {
            if (text == null || text.isBlank()) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + text.toLowerCase() + "%");
        });
    }

    public Specification<Debt> hasMinAmount(Double minAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (minAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), minAmount);
        });
    }

    public Specification<Debt> hasMaxAmount(Double maxAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (maxAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("amount"), maxAmount);
        });
    }

    public Specification<Debt> hasMinCreatedAt(LocalDateTime minCreatedAt) {
        return ((root, query, criteriaBuilder) -> {
            if (minCreatedAt == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
        });
    }

    public Specification<Debt> hasMaxCreatedAt(LocalDateTime maxCreatedAt) {
        return ((root, query, criteriaBuilder) -> {
            if (maxCreatedAt == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
        });
    }
}
