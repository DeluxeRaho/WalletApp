package com.bank.WalletApp.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TransactionRequestDto {
    
    @Schema(description = "Amount of the transaction", example = "150.00", required = true)
    private Long amount;
}
