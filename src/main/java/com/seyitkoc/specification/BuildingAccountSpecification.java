package com.seyitkoc.specification;

import com.seyitkoc.entity.BuildingAccount;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BuildingAccountSpecification {

    public Specification<BuildingAccount> byBuildingId (Long buildingId) {
        return (root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // No filter applied
            }
            return criteriaBuilder.equal(root.get("building").get("id"), buildingId);
        };
    }

    public Specification<BuildingAccount> byYear(Integer year) {
        return (root, query, criteriaBuilder) -> {
            if (year == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // No filter applied
            }
            return criteriaBuilder.equal(criteriaBuilder.function("YEAR", Integer.class, root.get("createdAt")), year);
        };
    }

}
