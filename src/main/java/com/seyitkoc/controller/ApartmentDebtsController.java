package com.seyitkoc.controller;

import com.seyitkoc.dto.ApiResponse;
import com.seyitkoc.service.IApartmentDebtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apartment-debts")
public class ApartmentDebtsController {
    private final IApartmentDebtService apartmentDebtService;

    public ApartmentDebtsController(IApartmentDebtService apartmentDebtService) {
        this.apartmentDebtService = apartmentDebtService;
    }

    @PatchMapping("/paid")
    public ApiResponse<String> paidDebt(@RequestParam("apartmentDebtId") Long apartmentDebtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentDebtService.paidDebt(token, apartmentDebtId));
    }

    @PatchMapping("/confirm")
    public ApiResponse<String> confirmDebtPayment(@RequestParam("apartmentDebtId") Long apartmentDebtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentDebtService.confirmDebtPayment(apartmentDebtId, token));
    }
}
