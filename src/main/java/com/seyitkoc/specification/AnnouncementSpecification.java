package com.seyitkoc.specification;

import com.seyitkoc.entity.Announcement;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AnnouncementSpecification {

    public Specification<Announcement> byBuildingId (Long buildingId) {
        return (root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("building").get("id"), buildingId);
        };
    }

    public Specification<Announcement> byApartmentId(Long apartmentId) {
        return (root, query, criteriaBuilder) -> {
            if (apartmentId == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("apartmentAnnouncements").get("apartment").get("id"), apartmentId);
        };
    }

    public Specification<Announcement> byIsRead(Boolean isRead) {
        return (root, query, criteriaBuilder) -> {
            if (isRead == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("isRead"), isRead);
        };
    }

    public Specification<Announcement> byText(String text) {
        return (root, query, criteriaBuilder) -> {
            if (text == null || text.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + text.toLowerCase() + "%"),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("content")), "%" + text.toLowerCase() + "%")
            );
        };
    }

    public Specification<Announcement> byMinCreatedAt(LocalDateTime minCreatedAt) {
        return (root, query, criteriaBuilder) -> {
            if (minCreatedAt == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
        };
    }
    public Specification<Announcement> byMaxCreatedAt(LocalDateTime maxCreatedAt) {
        return (root, query, criteriaBuilder) -> {
            if (maxCreatedAt == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
        };
    }

    public Specification<Announcement> byCreatedBy(String createdBy) {
        return (root, query, criteriaBuilder) -> {
            if (createdBy == null || createdBy.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(criteriaBuilder.lower(root.get("createdBy")), createdBy.toLowerCase());
        };
    }


}
