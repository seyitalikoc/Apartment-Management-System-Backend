package com.seyitkoc.service.impl;

import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;
import com.seyitkoc.entity.building.BuildingAccount;
import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.mapper.TransactionMapper;
import com.seyitkoc.repository.TransactionRepository;
import com.seyitkoc.security.JwtTokenService;
import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.service.ITransactionService;
import com.seyitkoc.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {
    private final TransactionRepository transactionRepository;
    private final IBuildingAccountService buildingAccountService;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, IBuildingAccountService buildingAccountService, IUserService userService, JwtTokenService jwtTokenService, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.buildingAccountService = buildingAccountService;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public DtoTransaction createTransaction(DtoTransactionIU dtoTransactionIU, String token) {
        BuildingAccount buildingAccount = buildingAccountService.getBuildingAccountById(dtoTransactionIU.getBuildingAccountId());
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingAccount.getBuilding().getId());

        Transaction transaction = transactionMapper.toEntity(dtoTransactionIU, buildingAccount);
        return transactionMapper.toDto(transactionRepository.save(transaction));
    }
}
