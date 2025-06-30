package com.seyitkoc.controller;

import com.seyitkoc.dto.ApiResponse;
import com.seyitkoc.dto.apartment.account.DtoApartmentAccount;
import com.seyitkoc.service.IApartmentAccountService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apartment-account")
public class ApartmentAccountController {
    private final IApartmentAccountService apartmentAccountService;

    public ApartmentAccountController(IApartmentAccountService apartmentAccountService) {
        this.apartmentAccountService = apartmentAccountService;
    }

    @GetMapping("{accountId}/get")
    public ApiResponse<DtoApartmentAccount> getApartmentAccountDetailsById(@RequestHeader("Authorization") String token, @PathVariable(name = "accountId") Long accountId) {
        return ApiResponse.ok(apartmentAccountService.getApartmentAccountDetails(token, accountId));
    }

    @GetMapping("get-all-by-building")
    public ApiResponse<Page<DtoApartmentAccount>> getAllApartmentAccountsByBuildingId(
            @RequestHeader("Authorization") String token,
            @RequestParam("buildingId") Long buildingId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection) {
        return ApiResponse.ok(apartmentAccountService.getAllApartmentAccountsByBuildingId(token, buildingId, page, size, sortBy, sortDirection));
    }
}
