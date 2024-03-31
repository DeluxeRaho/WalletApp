package com.bank.WalletApp.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Entity
@Data
@Table(name = "Transactions")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name = "Transaction ID")
    @GeneratedValue
    private Long transactionId;

    @Enumerated
    @NonNull
    @Column(name = "Transaction Type")
    private TransactionType type;

    @NonNull
    @Column(name = "Amount")
    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User ID")
    @NonNull
    private User user;
}
