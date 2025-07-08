package com.seyitkoc.controller;

import com.seyitkoc.service.IAnnouncementService;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/announcements")
public class AnnouncementController {
    private final IAnnouncementService announcementService;


    public AnnouncementController(IAnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    // CRUD Operations
    @PostMapping
    public ApiResponse<DtoAnnouncement> createAnnouncement(@Valid @RequestBody DtoAnnouncementIU dtoAnnouncementIU,
                                                           @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(announcementService.createAnnouncement(dtoAnnouncementIU, token));
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoAnnouncement> getAnnouncementById(
            @PathVariable("id") Long announcementId,
            @RequestParam(required = false) Long apartmentId,
            @RequestParam(required = false) Long buildingId,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(announcementService.getAnnouncementById(announcementId, apartmentId, buildingId, token));
    }

    @PutMapping("/{id}")
    public ApiResponse<DtoAnnouncement> updateAnnouncement(
            @PathVariable("id") Long announcementId,
            @Valid @RequestBody DtoAnnouncementIU dtoAnnouncementIU,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(announcementService.updateAnnouncement(announcementId, dtoAnnouncementIU, token));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteAnnouncement(
            @PathVariable("id") Long announcementId,
            @RequestHeader("Authorization") String token) {
        announcementService.deleteAnnouncement(announcementId, token);
        return ApiResponse.ok(null);
    }
}
