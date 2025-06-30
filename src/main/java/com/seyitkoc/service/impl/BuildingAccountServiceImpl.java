package com.seyitkoc.service.impl;

import com.seyitkoc.dto.building.account.DtoBuildingAccount;
import com.seyitkoc.dto.building.account.DtoBuildingAccountIU;
import com.seyitkoc.entity.building.Building;
import com.seyitkoc.entity.building.BuildingAccount;
import com.seyitkoc.enums.AccountType;
import com.seyitkoc.exception.ApplicationException;
import com.seyitkoc.exception.ErrorMessage;
import com.seyitkoc.exception.MessageType;
import com.seyitkoc.mapper.BuildingAccountMapper;
import com.seyitkoc.repository.BuildingAccountRepository;
import com.seyitkoc.repository.BuildingRepository;
import com.seyitkoc.security.JwtTokenService;
import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingAccountServiceImpl implements IBuildingAccountService {
    private final BuildingAccountRepository buildingAccountRepository;
    private final BuildingRepository buildingRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final BuildingAccountMapper buildingAccountMapper;

    public BuildingAccountServiceImpl(
            BuildingAccountRepository buildingAccountRepository,
            BuildingRepository buildingRepository,
            IUserService iUserService,
            JwtTokenService jwtTokenService,
            BuildingAccountMapper buildingAccountMapper
    ) {
        this.buildingAccountRepository = buildingAccountRepository;
        this.buildingRepository = buildingRepository;
        this.userService = iUserService;
        this.jwtTokenService = jwtTokenService;
        this.buildingAccountMapper = buildingAccountMapper;
    }

    @Override
    public void createAccountsWhenBuildingCreate(Building building) {
        List<BuildingAccount> cashAccounts = new ArrayList<>();
        cashAccounts.add(new BuildingAccount(null, "Nakit Kasası", LocalDateTime.now().getYear(), 0.0, AccountType.CASH, LocalDateTime.now(), LocalDateTime.now(), true, building, new ArrayList<>()));
        cashAccounts.add(new BuildingAccount(null, "Banka Kasası", LocalDateTime.now().getYear(), 0.0, AccountType.BANK, LocalDateTime.now(), LocalDateTime.now(), true, building, new ArrayList<>()));
        buildingAccountRepository.saveAll(cashAccounts);
    }

    @Override
    public DtoBuildingAccount createBuildingAccount(String token, DtoBuildingAccountIU dtoBuildingAccountIU) {
        if (userService.isNotManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoBuildingAccountIU.getBuildingId())){
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "You are not authorized to create a building account for this building."));
        }
        BuildingAccount buildingAccount = buildingAccountMapper.toBuildingAccount(dtoBuildingAccountIU, buildingRepository.findById(dtoBuildingAccountIU.getBuildingId()).orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building not found."))));
        return buildingAccountMapper.toDtoBuildingAccount(buildingAccount);
    }

    @Override
    public Page<DtoBuildingAccount> getBuildingAccountsByBuildingId(Long buildingId, Integer page, Integer size, String sortBy, String sortDirection, String token) {
        if (userService.isNotUserMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingId)) {
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "You are not authorized to view accounts for this building."));
        }
        int pageNumber = (page != null) ? page : 0;
        int pageSize = (size != null) ? size : 10;
        String sortField = (sortBy != null && !sortBy.isEmpty()) ? sortBy : "id";
        Sort.Direction direction = "DESC".equalsIgnoreCase(sortDirection) ? Sort.Direction.DESC : Sort.Direction.ASC;

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortField));
        Page<BuildingAccount> buildingAccounts = buildingAccountRepository.findAllByBuildingId(buildingId, pageRequest);
        return buildingAccounts.map(buildingAccountMapper::toDtoBuildingAccount);
    }

    @Override
    public DtoBuildingAccount getBuildingAccountById(Long id, String token) {
        if (userService.isNotUserMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingAccountRepository.findById(id).orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found."))).getBuilding().getId())) {
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "You are not authorized to view this building account."));
        }
        return buildingAccountMapper.toDtoBuildingAccount(buildingAccountRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found."))));
    }

    @Override
    public DtoBuildingAccount updateBuildingAccount(String token, Long accountId, DtoBuildingAccountIU dtoBuildingAccountIU) {
        if (userService.isNotManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoBuildingAccountIU.getBuildingId())) {
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "You are not authorized to update this building account."));
        }
        BuildingAccount existingAccount = buildingAccountRepository.findById(accountId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found.")));
        if (!existingAccount.isActive() || !existingAccount.getBuilding().getId().equals(dtoBuildingAccountIU.getBuildingId())) {
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "You are not authorized to update this building account."));
        }
        existingAccount.setAccountName(dtoBuildingAccountIU.getName());
        existingAccount.setAccountType(AccountType.valueOf(dtoBuildingAccountIU.getType()));
        existingAccount.setBalance(existingAccount.getBalance() == 0 ? dtoBuildingAccountIU.getBalance() : existingAccount.getBalance());

        return buildingAccountMapper.toDtoBuildingAccount(buildingAccountRepository.save(existingAccount));
    }

    @Override
    public BuildingAccount getBuildingAccountById(Long id) {
        return buildingAccountRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found.")));
    }
}