package com.seyitkoc.service.impl;

import com.seyitkoc.service.ITransactionService;
import com.seyitkoc.mapper.TransactionMapper;
import com.seyitkoc.repository.TransactionRepository;
import com.seyitkoc.specification.TransactionSpecification;
import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;
import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
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
    @Transactional
    public DtoTransaction createTransaction(DtoTransactionIU dtoTransactionIU, String token) {
        BuildingAccount buildingAccount = buildingAccountService.getBuildingAccountById(dtoTransactionIU.getBuildingAccountId());
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingAccount.getBuilding().getId());

        Transaction transaction = transactionRepository.save(transactionMapper.toEntity(dtoTransactionIU, buildingAccount));
        buildingAccountService.updateBuildingAccountBalance(transaction.getBuildingAccount().getId());
        return transactionMapper.toDto(transaction);
    }

    @Override
    public DtoTransaction getTransactionById(String token, Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), transaction.getBuildingId());
        return transactionMapper.toDto(transaction);
    }

    @Override
    @Transactional
    public DtoTransaction updateTransaction(DtoTransactionIU dtoTransaction, String token, Long id) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), existingTransaction.getBuildingId());

        Transaction updatedTransaction = transactionMapper.toEntity(dtoTransaction,
                existingTransaction.getBuildingAccount().getId().equals(dtoTransaction.getBuildingAccountId()) ?
                        existingTransaction.getBuildingAccount() : buildingAccountService.getBuildingAccountById(dtoTransaction.getBuildingAccountId()));
        updatedTransaction.setId(id);

        Transaction savedTransaction = transactionRepository.save(updatedTransaction);
        buildingAccountService.updateBuildingAccountBalance(savedTransaction.getBuildingAccount().getId());
        return transactionMapper.toDto(savedTransaction);
    }

    @Override
    @Transactional
    public void deleteTransaction(String token, Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), transaction.getBuildingId());
        transactionRepository.delete(transaction);
        buildingAccountService.updateBuildingAccountBalance(transaction.getBuildingAccount().getId());
    }

}
