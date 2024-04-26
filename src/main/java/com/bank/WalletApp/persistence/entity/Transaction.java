package com.bank.WalletApp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
public class Transaction{

    @Id
    @GeneratedValue
    @Column(name = "transactionId")
    private Long transactionId;

    @Enumerated
    @NonNull
    @Column(name = "transactionType")
    private TransactionType transactionType;

    @NonNull
    @Column(name = "amount")
    private Long amount;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "createdAt", nullable = false, updatable = false)
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @NonNull
    private User user;
}
