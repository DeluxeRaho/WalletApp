package com.bank.WalletApp.api.controller.controller;

import com.bank.WalletApp.api.controller.dto.TransactionRequestDto;
import com.bank.WalletApp.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TRANSACTIONS")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionRequestDto> getTransactionById(@PathVariable Long id){

        TransactionRequestDto transactionRequestDto = transactionService.getTransactionById(id);

        return ResponseEntity.ok(transactionRequestDto);
    }
}
