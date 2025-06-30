package com.seyitkoc.controller;

import com.seyitkoc.dto.ApiResponse;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import com.seyitkoc.service.IDebtService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/debts")
public class DebtController {
    private final IDebtService debtService;

    public DebtController(IDebtService debtService) {
        this.debtService = debtService;
    }

    @PostMapping("/create")
    public ApiResponse<DtoDebt> createDebt(@Valid @RequestBody DtoDebtIU dtoDebtIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.createDebt(token, dtoDebtIU));
    }

    @PutMapping("/{debtId}/update")
    public ApiResponse<DtoDebt> updateDebt(@PathVariable Long debtId, @Valid @RequestBody DtoDebtIU dtoDebtIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.updateDebt(token, debtId, dtoDebtIU));
    }

    @GetMapping("/{debtId}/get")
    public ApiResponse<DtoDebt> getDebtById(@PathVariable Long debtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.getDebtById(token, debtId));
    }

    @DeleteMapping("/{debtId}/delete")
    public ApiResponse<String> deleteDebt(@PathVariable Long debtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.deleteDebt(token, debtId));
    }

    @GetMapping("/get-by-building")
    public ApiResponse<Page<DtoDebt>> getAllDebtsByBuildingId(
            @RequestParam Long buildingId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String searchingText,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount,
            @RequestParam(required = false) LocalDateTime minCreatedAt,
            @RequestParam(required = false) LocalDateTime maxCreatedAt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.getAllDebtsByBuildingId(buildingId, type, searchingText, minAmount, maxAmount, minCreatedAt, maxCreatedAt, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("/get-by-apartment")
    public ApiResponse<Page<DtoDebt>> getAllDebtsByApartmentId(
            @RequestParam Long buildingId,
            @RequestParam Long apartmentId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String searchingText,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount,
            @RequestParam(required = false) LocalDateTime minCreatedAt,
            @RequestParam(required = false) LocalDateTime maxCreatedAt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.getAllDebtsByApartmentId(buildingId, apartmentId, type, searchingText, minAmount, maxAmount, minCreatedAt, maxCreatedAt, page, size, sortBy, sortDirection, token));
    }


}
