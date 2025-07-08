package com.seyitkoc.service.impl;

import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.mapper.BuildingAccountMapper;
import com.seyitkoc.repository.BuildingAccountRepository;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccountIU;
import com.seyitkoc.entity.Building;
import com.seyitkoc.enums.AccountType;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.repository.BuildingRepository;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.base.TransactionBaseService;
import com.seyitkoc.mapper.TransactionMapper;
import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
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
    private final TransactionBaseService transactionBaseService;
    private final TransactionMapper transactionMapper;

    public BuildingAccountServiceImpl(
            BuildingAccountRepository buildingAccountRepository,
            BuildingRepository buildingRepository,
            IUserService iUserService,
            JwtTokenService jwtTokenService,
            BuildingAccountMapper buildingAccountMapper, TransactionBaseService transactionBaseService, TransactionMapper transactionMapper
    ) {
        this.buildingAccountRepository = buildingAccountRepository;
        this.buildingRepository = buildingRepository;
        this.userService = iUserService;
        this.jwtTokenService = jwtTokenService;
        this.buildingAccountMapper = buildingAccountMapper;
        this.transactionBaseService = transactionBaseService;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public void createAccountsWhenBuildingCreate(Building building) {
        List<BuildingAccount> cashAccounts = new ArrayList<>();
        cashAccounts.add(new BuildingAccount(null, "Nakit Kasası", LocalDateTime.now().getYear(), 0.0, LocalDateTime.now(), 0.0, AccountType.CASH, LocalDateTime.now(), LocalDateTime.now(), true, building, new ArrayList<>()));
        cashAccounts.add(new BuildingAccount(null, "Banka Kasası", LocalDateTime.now().getYear(), 0.0, LocalDateTime.now(), 0.0, AccountType.BANK, LocalDateTime.now(), LocalDateTime.now(), true, building, new ArrayList<>()));
        buildingAccountRepository.saveAll(cashAccounts);
    }

    @Override
    @Transactional
    public void updateBuildingAccountBalance(Long buildingAccountId) {
        BuildingAccount buildingAccount = buildingAccountRepository.findById(buildingAccountId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found.")));

        buildingAccount.setBalance(buildingAccount.getBalanceCalculated());
        buildingAccount.setBalanceUpdatedAt(LocalDateTime.now());
        buildingAccountRepository.save(buildingAccount);
    }

    @Override
    @Transactional
    public DtoBuildingAccount createBuildingAccount(String token, DtoBuildingAccountIU dtoBuildingAccountIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoBuildingAccountIU.getBuildingId());
        BuildingAccount buildingAccount = buildingAccountMapper.toBuildingAccount(dtoBuildingAccountIU, buildingRepository.findById(dtoBuildingAccountIU.getBuildingId()).orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building not found."))));
        return buildingAccountMapper.toDtoBuildingAccount(buildingAccount);
    }

    @Override
    public DtoBuildingAccount getBuildingAccountById(Long id, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), id);

        return buildingAccountMapper.toDtoBuildingAccount(buildingAccountRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found."))));
    }

    @Override
    @Transactional
    public DtoBuildingAccount updateBuildingAccount(String token, Long accountId, DtoBuildingAccountIU dtoBuildingAccountIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoBuildingAccountIU.getBuildingId());

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

    @Override
    public Page<DtoTransaction> getAllTransactionsByAccountIdAndFilter(
            Long accountId, String type, String subType, Double minAmount, Double maxAmount, String text,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection, String token) {

        BuildingAccount buildingAccount = buildingAccountRepository.findById(accountId).orElseThrow(() ->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found.")));
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingAccount.getBuilding().getId());

        return transactionBaseService.getTransactionsByBuildingAccountIdAndFilter(
                accountId, type, subType, text, minAmount, maxAmount, startDate, endDate, page, size, sortBy, sortDirection)
                .map(transactionMapper::toDto);
    }
}