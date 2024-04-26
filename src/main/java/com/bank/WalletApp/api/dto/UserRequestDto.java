package com.bank.WalletApp.api.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private String name;
    private Long balance;
}
