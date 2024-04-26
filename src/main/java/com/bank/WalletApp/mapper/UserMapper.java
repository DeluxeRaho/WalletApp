package com.bank.WalletApp.mapper;

import com.bank.WalletApp.api.dto.UserRequestDto;
import com.bank.WalletApp.persistence.entity.User;

public class UserMapper {


    public static UserRequestDto toUserRequestDto(User user) {
        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setName(user.getName());
        userRequestDto.setBalance(user.getBalance());
        
        return userRequestDto;
    }
    
}
