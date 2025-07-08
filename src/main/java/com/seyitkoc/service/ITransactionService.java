package com.seyitkoc.service;

import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;

public interface ITransactionService {

    DtoTransaction createTransaction(DtoTransactionIU dtoTransactionIU, String token);

    DtoTransaction getTransactionById(String token, Long id);

    DtoTransaction updateTransaction(DtoTransactionIU dtoTransaction, String token, Long id);

    void deleteTransaction(String token, Long id);
}
