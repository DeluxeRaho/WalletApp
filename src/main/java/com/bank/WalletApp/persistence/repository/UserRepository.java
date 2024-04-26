package com.bank.WalletApp.persistence.repository;

import com.bank.WalletApp.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u.balance from User u where u.id = :userId")
    Optional<Long> getBalance(@Param("userId") Long userId);
    
    @Query(value = "select u.name from User u where u.id = :userId")
    Optional<Long> getName(@Param("userId") Long userId);

}
