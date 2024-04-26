package com.bank.WalletApp.mapper;

import com.bank.WalletApp.api.dto.TransactionResponseDto;
import com.bank.WalletApp.persistence.entity.Transaction;


import java.util.List;
import java.util.stream.Collectors;


public class TransactionMapper {
    public static TransactionResponseDto toTransactionResponseDto(Transaction transaction) {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();

        transactionResponseDto.setTransactionId(transaction.getTransactionId());
        transactionResponseDto.setAmount(transaction.getAmount());
        transactionResponseDto.setTransactionType(transaction.getTransactionType());
        transactionResponseDto.setCreatedAt(transaction.getCreatedAt());

        return transactionResponseDto;
    }

    public static List<TransactionResponseDto> toTransactionResponseDtoList(List<Transaction> transactions) {
        return transactions.stream().map(TransactionMapper::toTransactionResponseDto).collect(Collectors.toList());
    }
}
