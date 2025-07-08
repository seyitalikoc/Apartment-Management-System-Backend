package com.seyitkoc.service;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;

import java.util.List;

public interface IAnnouncementService {
    void createAnnouncement(String title, String content, String createdBy, Long buildingId, List<Long> apartmentIds);

    // CRUD Operations
    DtoAnnouncement createAnnouncement(DtoAnnouncementIU dtoAnnouncementIU, String token);
    DtoAnnouncement getAnnouncementById(Long announcementId, Long apartmentId, Long buildingId, String token);
    DtoAnnouncement updateAnnouncement(Long announcementId, DtoAnnouncementIU dtoAnnouncementIU, String token);
    void deleteAnnouncement(Long announcementId, String token);

}
