package com.seyitkoc.service.base;

import com.seyitkoc.entity.Announcement;
import com.seyitkoc.repository.AnnouncementRepository;
import com.seyitkoc.specification.AnnouncementSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnnouncementBaseService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementSpecification announcementSpecification;

    public AnnouncementBaseService(AnnouncementRepository announcementRepository, AnnouncementSpecification announcementSpecification) {
        this.announcementRepository = announcementRepository;
        this.announcementSpecification = announcementSpecification;
    }

    public Page<Announcement> findAnnouncementsByBuildingIdWithFilters(
            Long buildingId, String text,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, String createdBy,
            int page, int size, String sortBy, String sortDirection
    ) {
        Specification<Announcement> specification = Specification.where(announcementSpecification.byBuildingId(buildingId))
                .and(announcementSpecification.byText(text))
                .and(announcementSpecification.byMinCreatedAt(minCreatedAt))
                .and(announcementSpecification.byMaxCreatedAt(maxCreatedAt))
                .and(announcementSpecification.byCreatedBy(createdBy)); // Assuming createdBy is not used here, adjust as necessary

        return announcementRepository.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }

    public Page<Announcement> findAnnouncementsByApartmentIdWithFilters(
            Long apartmentId, String text,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            String createdBy, Boolean isRead,
            int page, int size, String sortBy, String sortDirection
    ) {
        Specification<Announcement> specification = Specification.where(announcementSpecification.byApartmentId(apartmentId))
                .and(announcementSpecification.byText(text))
                .and(announcementSpecification.byMinCreatedAt(minCreatedAt))
                .and(announcementSpecification.byMaxCreatedAt(maxCreatedAt))
                .and(announcementSpecification.byCreatedBy(createdBy))
                .and(announcementSpecification.byIsRead(isRead));

        return announcementRepository.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }
}
