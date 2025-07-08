package com.seyitkoc.controller;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.transaction.DtoTransaction;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/building")
public class BuildingController {
    private final IBuildingService buildingService;

    public BuildingController(IBuildingService buildingService) {
        this.buildingService = buildingService;
    }

    // CRUD Operations
    @PostMapping
    public ApiResponse<String> saveBuilding(@Valid @RequestBody DtoBuildingIU dtoBuildingIU) {
        return ApiResponse.ok(buildingService.saveBuilding(dtoBuildingIU));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<Page<DtoBuilding>> getAllBuildings(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {
        return ApiResponse.ok(buildingService.getAllBuildings(page, size, sortBy, sortDirection));
    }

    @GetMapping("{id}")
    public ApiResponse<DtoBuilding> getBuildingById(@RequestHeader("authorization") String token, @PathVariable(name = "id") Long buildingId){
        return ApiResponse.ok(buildingService.getBuildingById(token, buildingId));
    }

    @PutMapping("{id}/update")
    public ApiResponse<String> updateBuilding(@RequestBody DtoBuildingIU dtoBuildingIU, @PathVariable Long id, @RequestHeader("authorization") String token) {
        return ApiResponse.ok(buildingService.updateBuilding(dtoBuildingIU, id, token));
    }

    @DeleteMapping("{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<String> deleteBuilding(@PathVariable Long id) {
        return ApiResponse.ok( buildingService.deleteBuilding(id));
    }

    // Nested Resources (Sub-resources)
    @GetMapping("{id}/apartments")
    public ApiResponse<Page<DtoApartment>> getApartmentsByBuildingId(
            @RequestHeader("authorization") String token,
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {
        return ApiResponse.ok(buildingService.getAllApartmentsByBuildingId(token, buildingId, page, size, sortBy, sortDirection));
    }

    @GetMapping("{id}/apartments/accounts")
    public ApiResponse<Page<DtoApartmentAccount>> getApartmentAccountsByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader("authorization") String token){
        return ApiResponse.ok(buildingService
                .getAllApartmentAccountsByBuildingId(buildingId, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/announcements")
    public ApiResponse<Page<DtoAnnouncement>> getAnnouncementsByBuildingId(
            @RequestHeader("authorization") String token,
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(value = "createdBy", required = false) String createdBy,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "createdAt", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "desc", required = false) String sortDirection) {
        return ApiResponse.ok(buildingService.getAnnouncementsByBuildingId(token, buildingId, text, minCreatedAt, maxCreatedAt, createdBy, page, size, sortBy, sortDirection));
    }

    @GetMapping("{id}/accounts")
    public ApiResponse<Page<DtoBuildingAccount>> getBuildingAccountByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "year", defaultValue = "0", required = false) int year,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader("authorization") String token) {
        return ApiResponse.ok(buildingService.getAllBuildingAccountsByBuildingId(buildingId, year, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/transactions")
    public ApiResponse<Page<DtoTransaction>> getTransactionsByBuildingIdAndFilter(
            @PathVariable(name = "id") Long id,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String subType,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount,
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size,
            @RequestParam(defaultValue = "transactionDate", required = false) String sortBy,
            @RequestParam(defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(buildingService
                .getAllTransactionsByBuildingIdAndFilter(token, id, type, subType, minAmount, maxAmount, text, startDate, endDate,
                        page, size, sortBy, sortDirection));
    }

    @GetMapping("{id}/debts")
    public ApiResponse<Page<DtoDebt>> getDebtsByBuildingId(
            @PathVariable(name = "id") Long buildingId,
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
        return ApiResponse.ok(buildingService
                .getAllDebtsByBuildingIdAndFilter(buildingId, text, type, minAmount, maxAmount,
                        minCreatedAt, maxCreatedAt, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/due")
    public ApiResponse<DtoDue> getDueByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(buildingService.getDueByBuildingId(buildingId, token));
    }

    @GetMapping("{id}/polls")
    public ApiResponse<Page<DtoPoll>> getAllPollsByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(value = "isFinish", required = false) boolean isFinished,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader("authorization") String token){
        return ApiResponse.ok(buildingService.getAllPollsByBuildingId(buildingId, text, minCreatedAt, maxCreatedAt, isFinished, page, size, sortBy, sortDirection, token));
    }

    // Special Operations
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<String> updateBuildingStatus(@PathVariable Long id, @RequestParam(name = "status") String status) {
        return ApiResponse.ok(buildingService.updateBuildingStatus(id, status));
    }

    @PutMapping("{id}/change-manager")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<DtoBuilding> changeManager(@RequestParam(value = "managerId") Long managerId, @PathVariable(name = "id") Long buildingId) {
        return ApiResponse.ok(buildingService.changeManager(buildingId, managerId));
    }
}
