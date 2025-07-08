package com.seyitkoc.controller;

import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.ITransactionService;
import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ApiResponse<DtoTransaction> createTransaction(@Valid @RequestBody DtoTransactionIU dtoTransactionIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(transactionService.createTransaction(dtoTransactionIU, token));
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoTransaction> getTransactionById(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ApiResponse.ok(transactionService.getTransactionById(token, id));
    }

    @PutMapping("/{id}")
    public ApiResponse<DtoTransaction> updateTransaction(
            @Valid @RequestBody DtoTransactionIU dtoTransaction,
            @RequestHeader("Authorization") String token,
            @PathVariable Long id
    ) {
        return ApiResponse.ok(transactionService.updateTransaction(dtoTransaction, token, id));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTransaction(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        transactionService.deleteTransaction(token, id);
        return ApiResponse.ok(null);
    }

}
