package com.seyitkoc.specification;

import com.seyitkoc.entity.Poll;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PollSpecification {

    public Specification<Poll> byBuildingId(Long buildingId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingId == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("building").get("id"), buildingId);
        });
    }

    public Specification<Poll> byText(String text) {
        return ((root, query, criteriaBuilder) -> {
            if (text == null || text.isEmpty())
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + text.toLowerCase() + "%"),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + text.toLowerCase() + "%"));
        });
    }

    public Specification<Poll> byMinCreateAt(LocalDateTime minCreateAt) {
        return ((root, query, criteriaBuilder) -> {
            if (minCreateAt == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreateAt);
        });
    }

    public Specification<Poll> byMaxCreateAt(LocalDateTime maxCreateAt) {
        return ((root, query, criteriaBuilder) -> {
            if (maxCreateAt == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreateAt);
        });
    }

    public Specification<Poll> byIsFinished(Boolean isFinished) {
        return ((root, query, criteriaBuilder) -> {
            if (isFinished == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            if (isFinished)
                return criteriaBuilder.lessThanOrEqualTo(root.get("finishDate"), LocalDateTime.now());

            return criteriaBuilder.greaterThanOrEqualTo(root.get("finishDate"), LocalDateTime.now());
        });
    }
}
