package com.seyitkoc.controller;

import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.IDebtService;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/debts")
public class DebtController {
    private final IDebtService debtService;

    public DebtController(IDebtService debtService) {
        this.debtService = debtService;
    }

    @PostMapping
    public ApiResponse<DtoDebt> createDebt(@Valid @RequestBody DtoDebtIU dtoDebtIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.createDebt(token, dtoDebtIU));
    }

    @GetMapping("/{debtId}")
    public ApiResponse<DtoDebt> getDebtById(@PathVariable Long debtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.getDebtById(token, debtId));
    }

    @GetMapping("{id}/apartmentDebts")
    public ApiResponse<Page<DtoApartmentDebts>> getApartmentDebtsByDebtId(
            @PathVariable(name = "id") Long id,
            @RequestParam(value = "paid", required = false) Boolean isPaid,
            @RequestParam(value = "confirm", required = false) Boolean isConfirm,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(debtService
                .getApartmentDebtsByDebtIdAndFilter(id, isPaid, isConfirm, page, pageSize, sortBy, sortDirection, token));
    }

    @PutMapping("/{debtId}")
    public ApiResponse<DtoDebt> updateDebt(@PathVariable Long debtId, @Valid @RequestBody DtoDebtIU dtoDebtIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.updateDebt(token, debtId, dtoDebtIU));
    }

    @DeleteMapping("/{debtId}")
    public ApiResponse<String> deleteDebt(@PathVariable Long debtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.deleteDebt(token, debtId));
    }
}
