package com.seyitkoc.controller;

import com.seyitkoc.service.IApartmentDebtsService;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.common.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/apartmentDebts")
public class ApartmentDebtsController {
    private final IApartmentDebtsService apartmentDebtService;

    public ApartmentDebtsController(IApartmentDebtsService apartmentDebtService) {
        this.apartmentDebtService = apartmentDebtService;
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoApartmentDebts> getApartmentDebtByFilter(
            @PathVariable(name = "id") Long id,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(apartmentDebtService.getApartmentDebtByFilter(id, token));
    }

    @PatchMapping("/pay")
    public ApiResponse<String> paidDebt(@RequestParam("apartmentDebtId") Long apartmentDebtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentDebtService.paidDebt(token, apartmentDebtId));
    }

    @PatchMapping("/confirm")
    public ApiResponse<String> confirmDebtPayment(@RequestParam("apartmentDebtId") Long apartmentDebtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentDebtService.confirmDebtPayment(apartmentDebtId, token));
    }
}
