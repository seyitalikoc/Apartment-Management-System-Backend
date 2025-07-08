package com.seyitkoc.service;

import com.seyitkoc.entity.Announcement;
import com.seyitkoc.entity.Apartment;

import java.util.List;

public interface IApartmentAnnouncementService {
    void createApartmentAnnouncement(Announcement announcement, Apartment apartment);

    void updateApartmentAnnouncement(Announcement announcement, List<Long> apartmentIds);

    void readApartmentAnnouncement(Announcement announcement, Long apartmentId);
}
