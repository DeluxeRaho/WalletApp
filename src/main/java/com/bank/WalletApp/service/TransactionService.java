package com.bank.WalletApp.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionService transactionService;


    public TransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //Add dto get
}
