package com.seyitkoc.service.impl;

import com.seyitkoc.service.IApartmentAnnouncementService;
import com.seyitkoc.entity.Announcement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.entity.ApartmentAnnouncement;
import com.seyitkoc.repository.ApartmentAnnouncementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApartmentAnnouncementServiceImpl implements IApartmentAnnouncementService {
    private final ApartmentAnnouncementRepository apartmentAnnouncementRepository;
    private final IApartmentService apartmentService;

    public ApartmentAnnouncementServiceImpl(ApartmentAnnouncementRepository apartmentAnnouncementRepository, IApartmentService apartmentService) {
        this.apartmentAnnouncementRepository = apartmentAnnouncementRepository;
        this.apartmentService = apartmentService;
    }

    @Override
    @Transactional
    public void createApartmentAnnouncement(Announcement announcement, Apartment apartment) {
        if (announcement == null)
            throw new IllegalArgumentException("Announcement cannot be null");
        if (apartment == null)
            throw new IllegalArgumentException("Apartment cannot be null");

        ApartmentAnnouncement apartmentAnnouncement = ApartmentAnnouncement.builder()
                .announcement(announcement)
                .apartment(apartment)
                .isRead(false)
                .build();

        apartmentAnnouncementRepository.save(apartmentAnnouncement);
    }

    @Override
    @Transactional
    public void updateApartmentAnnouncement(Announcement announcement, List<Long> apartmentIds) {
        announcement.getApartmentAnnouncements().removeIf(apartmentAnnouncement ->
                !apartmentIds.contains(apartmentAnnouncement.getId())
        );

        Set<Long> existingApartmentIds = announcement.getApartmentAnnouncements().stream()
                .map(apartmentAnnouncement -> apartmentAnnouncement.getApartment().getId())
                .collect(Collectors.toSet());

        List<ApartmentAnnouncement> newApartmentAnnouncements = apartmentIds.stream()
                .filter(apartmentId -> !existingApartmentIds.contains(apartmentId))
                .map(apartmentId -> {
                    Apartment matchingApartment = apartmentService.getApartmentById(apartmentId);
                    return ApartmentAnnouncement.builder()
                            .announcement(announcement)
                            .apartment(matchingApartment)
                            .isRead(false)
                            .build();
                })
                .toList();
        announcement.getApartmentAnnouncements().addAll(newApartmentAnnouncements);
        apartmentAnnouncementRepository.saveAll(announcement.getApartmentAnnouncements());
    }

    @Override
    @Transactional
    public void readApartmentAnnouncement(Announcement announcement, Long apartmentId) {
        ApartmentAnnouncement apartmentAnnouncement = announcement.getApartmentAnnouncements().stream()
                .filter(aa -> aa.getApartment().getId().equals(apartmentId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ApartmentAnnouncement not found for apartmentId: " + apartmentId));
        if (!apartmentAnnouncement.isRead()) {
            apartmentAnnouncement.setRead(true);
            apartmentAnnouncementRepository.save(apartmentAnnouncement);
        }
    }
}
