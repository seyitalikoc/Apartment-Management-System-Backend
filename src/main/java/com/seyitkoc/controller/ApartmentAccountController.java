package com.seyitkoc.controller;

import com.seyitkoc.service.IApartmentAccountService;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/apartmentAccounts")
public class ApartmentAccountController {
    private final IApartmentAccountService apartmentAccountService;

    public ApartmentAccountController(IApartmentAccountService apartmentAccountService) {
        this.apartmentAccountService = apartmentAccountService;
    }

    @GetMapping("{id}")
    public ApiResponse<DtoApartmentAccount> getApartmentAccountDetailsById(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Long accountId) {
        return ApiResponse.ok(apartmentAccountService.getApartmentAccountDetails(token, accountId));
    }

    @GetMapping("{id}/apartmentDebts")
    public ApiResponse<Page<DtoApartmentDebts>> getApartmentDebtsByApartmentAccountId(
            @PathVariable(name = "id") Long accountId,
            @RequestParam(value = "isPaid", required = false) Boolean isPaid,
            @RequestParam(value = "isConfirmed", required = false) Boolean isConfirmed,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ) {
        return ApiResponse.ok(apartmentAccountService.getApartmentDebtsByAccountIdAndFilter(
                accountId, isPaid, isConfirmed, page, pageSize, sortBy, sortDirection, token
        ));
    }
}
