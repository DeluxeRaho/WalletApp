package com.bank.WalletApp.service;

import com.bank.WalletApp.api.controller.dto.UserRequestDto;
import com.bank.WalletApp.persistence.entity.User;
import com.bank.WalletApp.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // add DTO get
    public UserRequestDto getUserById(Long id){
        User user = userRepository.findById(id);
        return UserRequestDto.builder()
                .name(user.getName())
                .balance(user.getBalance())
                .build();
    }
}
