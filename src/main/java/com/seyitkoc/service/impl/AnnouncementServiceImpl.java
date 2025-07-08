package com.seyitkoc.service.impl;

import com.seyitkoc.entity.Announcement;
import com.seyitkoc.mapper.AnnouncementMapper;
import com.seyitkoc.repository.AnnouncementRepository;
import com.seyitkoc.service.IAnnouncementService;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.service.IApartmentAnnouncementService;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {
    private final AnnouncementMapper announcementMapper;
    private final AnnouncementRepository announcementRepository;
    private final IBuildingService buildingService;
    private final IApartmentService apartmentService;
    private final IApartmentAnnouncementService apartmentAnnouncementService;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;

    public AnnouncementServiceImpl(AnnouncementMapper announcementMapper, AnnouncementRepository announcementRepository,
                                   IBuildingService buildingService, IApartmentService apartmentService,
                                   IApartmentAnnouncementService apartmentAnnouncementService, IUserService userService,
                                   JwtTokenService jwtTokenService) {
        this.announcementMapper = announcementMapper;
        this.announcementRepository = announcementRepository;
        this.buildingService = buildingService;
        this.apartmentService = apartmentService;
        this.apartmentAnnouncementService = apartmentAnnouncementService;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    // CRUD Operations
    @Override
    @Transactional
    public void createAnnouncement(String title, String content, String createdBy, Long buildingId, List<Long> apartmentIds) {
        DtoAnnouncementIU dtoAnnouncementIU = DtoAnnouncementIU.builder()
                .title(title)
                .content(content)
                .createdBy(createdBy)
                .buildingId(buildingId)
                .apartmentIds(new ArrayList<>())
                .build();
        Announcement announcement = announcementRepository.save(generateAnnouncement(dtoAnnouncementIU));

        apartmentIds.forEach(apartmentId -> {
            if (apartmentId != null) {
                apartmentAnnouncementService
                        .createApartmentAnnouncement(announcement, apartmentService.getApartmentById(apartmentId));
            }
        });
    }
    private Announcement generateAnnouncement(DtoAnnouncementIU dtoAnnouncementIU) {
        if (dtoAnnouncementIU == null)
            return null;

        return announcementMapper
                .createAnnouncement(dtoAnnouncementIU, buildingService.getBuildingById(dtoAnnouncementIU.getBuildingId()));
    }

    @Override
    @Transactional
    public DtoAnnouncement createAnnouncement(DtoAnnouncementIU dtoAnnouncementIU, String token) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), dtoAnnouncementIU.getBuildingId());

        Announcement existingAnnouncement = announcementRepository.save(generateAnnouncement(dtoAnnouncementIU));
        dtoAnnouncementIU.getApartmentIds().forEach(apartmentId -> {
            if (apartmentId != null) {
                apartmentAnnouncementService
                        .createApartmentAnnouncement(existingAnnouncement, apartmentService.getApartmentById(apartmentId));
            }
        });
        return announcementMapper.toDtoAnnouncement(existingAnnouncement);
    }

    @Override
    @Transactional
    public DtoAnnouncement getAnnouncementById(Long announcementId, Long apartmentId, Long buildingId, String token) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), announcement.getBuilding().getId());

        if (apartmentId != null)
            apartmentAnnouncementService.readApartmentAnnouncement(announcement, apartmentId);

        return announcementMapper.toDtoAnnouncement(announcement);
    }

    @Override
    @Transactional
    public DtoAnnouncement updateAnnouncement(Long announcementId, DtoAnnouncementIU dtoAnnouncementIU, String token) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), announcement.getBuilding().getId());

        applyChanges(announcement, dtoAnnouncementIU);
        return announcementMapper.toDtoAnnouncement(announcementRepository.save(announcement));
    }
    private void applyChanges(Announcement announcement, DtoAnnouncementIU dtoAnnouncementIU) {
        if (dtoAnnouncementIU.getTitle() != null) {
            announcement.setTitle(dtoAnnouncementIU.getTitle());
        }
        if (dtoAnnouncementIU.getContent() != null) {
            announcement.setContent(dtoAnnouncementIU.getContent());
        }
        if (dtoAnnouncementIU.getCreatedBy() != null) {
            announcement.setCreatedBy(dtoAnnouncementIU.getCreatedBy());
        }
        if (dtoAnnouncementIU.getApartmentIds() != null) {
            apartmentAnnouncementService.updateApartmentAnnouncement(announcement, dtoAnnouncementIU.getApartmentIds());
        }
        announcement.setUpdatedAt(LocalDateTime.now());
    }

    @Override
    @Transactional
    public void deleteAnnouncement(Long announcementId, String token) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), announcement.getBuilding().getId());

        announcementRepository.delete(announcement);
    }
}
