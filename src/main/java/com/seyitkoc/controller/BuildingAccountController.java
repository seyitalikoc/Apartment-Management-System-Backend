package com.seyitkoc.controller;

import com.seyitkoc.dto.building.account.DtoBuildingAccount;
import com.seyitkoc.dto.building.account.DtoBuildingAccountIU;
import com.seyitkoc.service.IBuildingAccountService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building-accounts")
public class BuildingAccountController {
    private final IBuildingAccountService buildingAccountService;

    public BuildingAccountController(IBuildingAccountService buildingAccountService) {
        this.buildingAccountService = buildingAccountService;
    }

    @GetMapping("/{accountId}/get")
    public DtoBuildingAccount getBuildingAccountById(@RequestHeader("Authorization") String token, @PathVariable(name = "accountId") Long accountId) {
        return buildingAccountService.getBuildingAccountById(accountId, token);
    }

    @GetMapping("/building/{buildingId}/get-all")
    public Page<DtoBuildingAccount> getBuildingAccountsByBuildingId(
            @RequestHeader("Authorization") String token,
            @PathVariable Long buildingId,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        return buildingAccountService.getBuildingAccountsByBuildingId(buildingId, page, size, sortBy, sortDirection, token);
    }

    @PostMapping("/create")
    public DtoBuildingAccount createBuildingAccount(@RequestHeader("Authorization") String token, @RequestBody DtoBuildingAccountIU dtoBuildingAccountIU) {
        return buildingAccountService.createBuildingAccount(token, dtoBuildingAccountIU);
    }

    @PutMapping("/{accountId}/update")
    public DtoBuildingAccount updateBuildingAccount(
            @RequestHeader("Authorization") String token,
            @PathVariable(name = "accountId") Long accountId,
            @RequestBody DtoBuildingAccountIU dtoBuildingAccountIU) {
        return buildingAccountService.updateBuildingAccount(token, accountId, dtoBuildingAccountIU);
    }

}
