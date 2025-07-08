package com.seyitkoc.mapper;

import com.seyitkoc.entity.Announcement;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;
import com.seyitkoc.entity.ApartmentAnnouncement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.Building;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class AnnouncementMapper {
    public Announcement createAnnouncement(DtoAnnouncementIU dtoAnnouncementIU, Building building) {
        if(dtoAnnouncementIU == null)
            return null;

        return  Announcement.builder()
                .title(dtoAnnouncementIU.getTitle())
                .content(dtoAnnouncementIU.getContent())
                .createdBy(dtoAnnouncementIU.getCreatedBy())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .building(building)
                .build();
    }

    public DtoAnnouncement toDtoAnnouncement(Announcement announcement) {
        if (announcement == null) {
            return null;
        }
        return DtoAnnouncement.builder()
                .id(announcement.getId())
                .title(announcement.getTitle())
                .content(announcement.getContent())
                .createdBy(announcement.getCreatedBy())
                .buildingId(announcement.getBuilding().getId())
                .buildingName(announcement.getBuilding().getName())
                .apartmentIds(announcement.getApartmentAnnouncements() != null ? announcement.getApartmentAnnouncements().stream()
                        .map(ApartmentAnnouncement::getApartment)
                        .map(Apartment::getId)
                        .collect(Collectors.toList()) : null
                )
                .apartmentNumbers( announcement.getApartmentAnnouncements() != null ? announcement.getApartmentAnnouncements().stream()
                        .map(ApartmentAnnouncement::getApartment)
                        .map(Apartment::getApartmentNumber)
                        .collect(Collectors.toList()) : null
                )
                .createdAt(announcement.getCreatedAt().toString())
                .updatedAt(announcement.getUpdatedAt().toString())
                .build();

    }
}
