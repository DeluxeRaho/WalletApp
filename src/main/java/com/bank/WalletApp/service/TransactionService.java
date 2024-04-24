package com.bank.WalletApp.service;

import com.bank.WalletApp.api.controller.dto.TransactionRequestDto;
import com.bank.WalletApp.api.controller.dto.UserRequestDto;
import com.bank.WalletApp.persistence.entity.Transaction;
import com.bank.WalletApp.persistence.entity.User;
import com.bank.WalletApp.persistence.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public TransactionRequestDto getTransactionById(Long id) throws NoSuchElementException {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()) {
            return TransactionRequestDto.builder()
                    .type(transaction.get().getType())
                    .amount(transaction.get().getAmount())
                    .date(transaction.get().getDate())
                    .user(transaction.get().getUser())
                    .build();
        }
        throw new NoSuchElementException("No transaction with this ID");
    }
}
