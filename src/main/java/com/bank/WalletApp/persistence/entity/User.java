package com.bank.WalletApp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "balance")
    @NonNull
    private Long balance;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
}
