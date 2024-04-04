package com.bank.WalletApp.api.controller.dto;

import com.bank.WalletApp.persistence.entity.TransactionType;
import com.bank.WalletApp.persistence.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@Builder
public class TransactionRequestDto {
    private TransactionType type;
    private Long amount;
    private Date date;
    private User user;
}
