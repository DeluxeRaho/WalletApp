package com.bank.WalletApp.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionRequestDto {
    @Schema(description = "Amount of the transaction", example = "150.00")
    private Long amount;
}
