package com.bank.WalletApp.service;

import com.bank.WalletApp.api.controller.dto.UserRequestDto;
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

    // add DTO get
    public UserRequestDto getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return UserRequestDto.builder()
                .name(user.get().getName())
                .balance(user.get().getBalance())
                .build();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
