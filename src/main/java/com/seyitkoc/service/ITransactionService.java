package com.seyitkoc.service;

import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;
import org.springframework.data.domain.Page;

public interface ITransactionService {

    DtoTransaction createTransaction(DtoTransactionIU dtoTransaction, String token);

    //Page<DtoTransaction> getTransactions(String token, );
}
