package com.seyitkoc.controller;

import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccountIU;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.transaction.DtoTransaction;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/buildingAccounts")
public class BuildingAccountController {
    private final IBuildingAccountService buildingAccountService;

    public BuildingAccountController(IBuildingAccountService buildingAccountService) {
        this.buildingAccountService = buildingAccountService;
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoBuildingAccount> getBuildingAccountById(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Long accountId) {
        return ApiResponse.ok(buildingAccountService.getBuildingAccountById(accountId, token));
    }

    @GetMapping("{id}/transactions")
    public ApiResponse<Page<DtoTransaction>> getTransactionsByAccountId(
            @PathVariable(name = "id") Long accountId,
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
            @RequestHeader("Authorization") String token){
        return ApiResponse.ok(buildingAccountService
                .getAllTransactionsByAccountIdAndFilter(accountId, type, subType, minAmount, maxAmount, text,
                        startDate, endDate, page, size, sortBy, sortDirection, token));
    }

    @PostMapping
    public DtoBuildingAccount createBuildingAccount(@RequestHeader("Authorization") String token, @RequestBody DtoBuildingAccountIU dtoBuildingAccountIU) {
        return buildingAccountService.createBuildingAccount(token, dtoBuildingAccountIU);
    }

    @PutMapping("/{id}")
    public DtoBuildingAccount updateBuildingAccount(
            @RequestHeader("Authorization") String token,
            @PathVariable(name = "id") Long accountId,
            @RequestBody DtoBuildingAccountIU dtoBuildingAccountIU) {
        return buildingAccountService.updateBuildingAccount(token, accountId, dtoBuildingAccountIU);
    }

}
