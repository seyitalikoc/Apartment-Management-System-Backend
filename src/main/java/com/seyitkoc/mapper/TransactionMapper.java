package com.seyitkoc.mapper;

import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;
import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.entity.transaction.Expense;
import com.seyitkoc.entity.transaction.Income;
import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.enums.ExpenseType;
import com.seyitkoc.enums.IncomeType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {
    public Transaction toEntity(DtoTransactionIU dtoTransactionIU, BuildingAccount buildingAccount) {
        if (dtoTransactionIU == null) {
            return null;
        }
        Transaction transaction;
        if (dtoTransactionIU.getType().equals("INCOME")) {
            transaction = Income.builder()
                    .amount(dtoTransactionIU.getAmount())
                    .description(dtoTransactionIU.getDescription())
                    .buildingAccount(buildingAccount)
                    .transactionDate(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .buildingId(buildingAccount.getBuilding().getId())
                    .incomeType(IncomeType.valueOf(dtoTransactionIU.getSubType().toUpperCase()))
                    .build();
        } else if (dtoTransactionIU.getType().equals("EXPENSE")) {
            transaction = Expense.builder()
                    .amount(dtoTransactionIU.getAmount())
                    .description(dtoTransactionIU.getDescription())
                    .buildingAccount(buildingAccount)
                    .transactionDate(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .buildingId(buildingAccount.getBuilding().getId())
                    .expenseType(ExpenseType.valueOf(dtoTransactionIU.getSubType().toUpperCase()))
                    .build();
        } else {
            throw new IllegalArgumentException("Invalid transaction type: " + dtoTransactionIU.getType());
        }
        return transaction;
    }

    public DtoTransaction toDto(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        return DtoTransaction.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .transactionDate(transaction.getTransactionDate().toString())
                .updatedAt(transaction.getUpdatedAt() != null ? transaction.getUpdatedAt().toString() : null)
                .buildingAccountId(transaction.getBuildingAccount().getId())
                .buildingAccountName(transaction.getBuildingAccount().getAccountName())
                .type(transaction instanceof Income ? "INCOME" : "EXPENSE")
                .subType(transaction instanceof Income ? ((Income) transaction).getIncomeType().name() : ((Expense) transaction).getExpenseType().name())
                .build();
    }
}
