package com.bank.WalletApp.api.dto;

import com.bank.WalletApp.persistence.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDto {
    private Long amount;
    private Long transactionId;
    private TransactionType transactionType;
    private Date createdAt;
}
