package com.seyitkoc.specification;

import com.seyitkoc.entity.polling.Poll;
import org.springframework.data.jpa.domain.Specification;

public class PollSpecification {

    public static Specification<Poll> hasId(Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }
    public static Specification<Poll> hasBuildingId(Long buildingId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("building").get("id"), buildingId);
    }
    public static Specification<Poll> hasIsActive(Boolean isActive) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isActive"), isActive);
    }

    public static Specification<Poll> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), title);
    }
    public static Specification<Poll> hasDescription(String description) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), description);
    }

    public static Specification<Poll> hasMinCreatedAt(Long minCreatedAt) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
    }
    public static Specification<Poll> hasMaxCreatedAt(Long maxCreatedAt) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
    }

    public static Specification<Poll> hasMinFinishedAt(Long minFinishedAt) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("finishedAt"), minFinishedAt);
    }
    public static Specification<Poll> hasMaxFinishedAt(Long maxFinishedAt) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("finishedAt"), maxFinishedAt);
    }

}
