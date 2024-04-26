package com.bank.WalletApp.service;

import com.bank.WalletApp.api.dto.UserRequestDto;
import com.bank.WalletApp.persistence.entity.User;
import com.bank.WalletApp.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long getBalance(Long userId) {
        return this.userRepository.getBalance(userId).orElseThrow(
                () -> new IllegalArgumentException("No user with that ID")); //TODO: Create correct Exceptions
    }

    public UserRequestDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("No user with that ID")); //TODO: Create correct Exceptions
        return new UserRequestDto(user.getName(), user.getBalance());
    }

    public Optional<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }

    public void createCreditByUserId(Long userId, Long amount) {
        User user = this.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("No user with that ID")); //TODO: Create correct Exceptions
        user.setBalance(user.getBalance() + amount);
        this.userRepository.save(user);
    }

    public void createDebitByUserId(Long userId, Long amount) {
        User user = this.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("No user with that ID")); //TODO: Create correct Exceptions
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            this.userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Amount is more than available balance");
        }
    }
}
