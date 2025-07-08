package com.seyitkoc.service;

import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccountIU;
import com.seyitkoc.entity.Building;
import com.seyitkoc.dto.transaction.DtoTransaction;
import org.springframework.data.domain.Page;

public interface IBuildingAccountService {
    void createAccountsWhenBuildingCreate(Building building);

    void updateBuildingAccountBalance(Long buildingAccountId);

    DtoBuildingAccount createBuildingAccount(String token, DtoBuildingAccountIU dtoBuildingAccountIU);

    DtoBuildingAccount getBuildingAccountById(Long id, String token);

    DtoBuildingAccount updateBuildingAccount(String token, Long accountId, DtoBuildingAccountIU dtoBuildingAccountIU);

    BuildingAccount getBuildingAccountById(Long id);

    Page<DtoTransaction> getAllTransactionsByAccountIdAndFilter(
            Long accountId, String type, String subType, Double minAmount, Double maxAmount, String text,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection, String token);
}
