package com.bank.WalletApp.service;

import com.bank.WalletApp.api.dto.TransactionResponseDto;
import com.bank.WalletApp.mapper.TransactionMapper;
import com.bank.WalletApp.persistence.entity.Transaction;
import com.bank.WalletApp.persistence.entity.TransactionType;
import com.bank.WalletApp.persistence.entity.User;
import com.bank.WalletApp.persistence.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    public List<TransactionResponseDto> getAllTransactionsByUserId(Long userId) {
        return TransactionMapper.toTransactionResponseDtoList(transactionRepository.getAllTransactionsByUserId(userId));
    }

    @Transactional //Either everything we planned works perfectly, or let's pretend we didn't do anything at all
    public TransactionResponseDto createCreditByUserId(Long userId, Long amount) {
        Optional<User> user = this.userService.findById(userId);
        if (!user.isPresent()) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.Credit);
        transaction.setAmount(amount);  // Set the transaction amount here

        this.userService.createCreditByUserId(userId, amount); // Pass amount from parameter

        transaction.setUser(user.get());
        return TransactionMapper.toTransactionResponseDto(transactionRepository.save(transaction));
    }


    @Transactional //Either everything we planned works perfectly, or let's pretend we didn't do anything at all
    public TransactionResponseDto createDebitByUserId(Long userId, Long amount) {
        Optional<User> user = this.userService.findById(userId);
        if (!user.isPresent()) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.Debit);
        transaction.setAmount(amount);  // Set the transaction amount here

        this.userService.createDebitByUserId(userId, amount); // Pass amount from parameter

        transaction.setUser(user.get());
        return TransactionMapper.toTransactionResponseDto(transactionRepository.save(transaction));
    }
}
