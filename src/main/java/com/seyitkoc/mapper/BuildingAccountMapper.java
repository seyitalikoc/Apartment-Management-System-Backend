package com.seyitkoc.mapper;

import com.seyitkoc.dto.building.account.DtoBuildingAccount;
import com.seyitkoc.dto.building.account.DtoBuildingAccountIU;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.building.BuildingAccount;
import com.seyitkoc.enums.AccountType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BuildingAccountMapper {
    public BuildingAccount toBuildingAccount(DtoBuildingAccountIU dtoBuildingAccountIU, Building building) {
        return BuildingAccount.builder()
                .accountName(dtoBuildingAccountIU.getName())
                .accountType(AccountType.valueOf(dtoBuildingAccountIU.getType()))
                .year(LocalDateTime.now().getYear())
                .balance(dtoBuildingAccountIU.getBalance())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .building(building)
                .isActive(true)
                .build();
    }

    public DtoBuildingAccount toDtoBuildingAccount(BuildingAccount buildingAccount) {
        return DtoBuildingAccount.builder()
                .id(buildingAccount.getId())
                .name(buildingAccount.getAccountName())
                .year(buildingAccount.getYear())
                .balance(buildingAccount.getBalance())
                .type(buildingAccount.getAccountType().name())
                .createdAt(buildingAccount.getCreatedAt())
                .updatedAt(buildingAccount.getUpdatedAt())
                .isActive(buildingAccount.isActive())
                .buildingId(buildingAccount.getBuilding().getId())
                .build();
    }
}
