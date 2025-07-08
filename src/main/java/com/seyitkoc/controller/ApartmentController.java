package com.seyitkoc.controller;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.debt.DtoDebt;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/apartments")
public class ApartmentController {
    private final IApartmentService apartmentService;

    public ApartmentController(IApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoApartment> getApartmentById(@PathVariable(name = "id") Long apartmentId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentService.getApartmentById(token, apartmentId));
    }

    // Nested Resources
    @GetMapping("{id}/account")
    public ApiResponse<DtoApartmentAccount> getAccountByApartmentId(
            @PathVariable(name = "id") Long apartmentId,
            @RequestHeader(value = "Authorization") String token
    ) {
        return ApiResponse.ok(apartmentService.getAccountByApartmentId(token, apartmentId));
    }

    @GetMapping("{id}/announcements")
    public ApiResponse<Page<DtoAnnouncement>> getAnnouncementsByApartmentId(
            @PathVariable(name = "id") Long apartmentId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(value = "createdBy", required = false) String createdBy,
            @RequestParam(value = "isRead", required = false) Boolean isRead,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "createdAt", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "desc", required = false) String sortDirection,
            @RequestHeader(value = "Authorization") String token) {
        return ApiResponse.ok(apartmentService.getAllAnnouncementsByApartmentIdAndFilter(apartmentId, text, minCreatedAt, maxCreatedAt, createdBy, isRead, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/debts")
    public ApiResponse<Page<DtoDebt>> getDebtsByApartmentId(
            @PathVariable(name = "id") Long apartmentId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minAmount", required = false) Double minAmount,
            @RequestParam(value = "maxAmount", required = false) Double maxAmount,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(apartmentService.getAllDebtsByApartmentIdAndFilter(
                apartmentId, text, type, minAmount, maxAmount, minCreatedAt, maxCreatedAt,
                page, size, sortBy, sortDirection, token
        ));
    }

    // get owner and tenant


    // Special Operations
    @PatchMapping("/{apartmentId}/setOwner")
    public ApiResponse<DtoApartment> setApartmentOwner(
            @PathVariable(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "userId") Long userId,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentService.setApartmentOwner(token, apartmentId, userId));
    }

    @PatchMapping("/{apartmentId}/setTenant")
    public ApiResponse<DtoApartment> setApartmentTenant(
            @PathVariable(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "userId") Long userId,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentService.setApartmentTenant(token, apartmentId, userId));
    }
}
