package com.seyitkoc.service;

import com.seyitkoc.dto.building.account.DtoBuildingAccount;
import com.seyitkoc.dto.building.account.DtoBuildingAccountIU;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.building.BuildingAccount;
import org.springframework.data.domain.Page;

public interface IBuildingAccountService {
    void createAccountsWhenBuildingCreate(Building building);
    DtoBuildingAccount createBuildingAccount(String token , DtoBuildingAccountIU dtoBuildingAccountIU);
    Page<DtoBuildingAccount> getBuildingAccountsByBuildingId(Long buildingId, Integer page, Integer size, String sortBy, String sortDirection, String token);
    DtoBuildingAccount getBuildingAccountById(Long id, String token);
    DtoBuildingAccount updateBuildingAccount(String token, Long accountId, DtoBuildingAccountIU dtoBuildingAccountIU);

    BuildingAccount getBuildingAccountById(Long id);
}
