package com.seyitkoc.mapper;

import com.seyitkoc.repository.BuildingAccountRepository;
import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccountIU;
import com.seyitkoc.entity.Building;
import com.seyitkoc.enums.AccountType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BuildingAccountMapper {
    private final BuildingAccountRepository buildingAccountRepository;

    public BuildingAccountMapper(BuildingAccountRepository buildingAccountRepository) {
        this.buildingAccountRepository = buildingAccountRepository;
    }

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
        buildingAccount.setBalance(buildingAccount.getBalanceCalculated());
        buildingAccount.setBalanceUpdatedAt(LocalDateTime.now());
        buildingAccountRepository.save(buildingAccount);

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
