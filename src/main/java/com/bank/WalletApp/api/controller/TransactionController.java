package com.bank.WalletApp.api.controller;

import com.bank.WalletApp.api.dto.TransactionRequestDto;
import com.bank.WalletApp.api.dto.TransactionResponseDto;
import com.bank.WalletApp.service.TransactionService;
import com.bank.WalletApp.mapper.TransactionMapper;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TRANSACTIONS")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Get all transactions by userId")
    @GetMapping("/{userId}")
    public ResponseEntity<List<TransactionResponseDto>> getAllTransactionsByUserId(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.transactionService.getAllTransactionsByUserId(userId));
    }

    @Operation(summary = "Create a credit transaction for a user by userId")
    @PostMapping("/CREDIT/{userId}")
    public ResponseEntity<TransactionResponseDto> createCreditTransactionForUserId(@PathVariable Long userId, @RequestBody Long amount) {

        TransactionResponseDto transactionResponseDto = transactionService.createCreditByUserId(userId, amount);

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponseDto);
    }


    @Operation(summary = "Create a debit transaction for a user by userId")
    @PostMapping("/DEBIT/{userId}")
    public ResponseEntity<TransactionResponseDto> createDebitTransactionForUserId(@PathVariable Long userId, @RequestBody Long amount) {

        TransactionResponseDto transactionResponseDto = transactionService.createDebitByUserId(userId, amount);

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponseDto);
    }
}
