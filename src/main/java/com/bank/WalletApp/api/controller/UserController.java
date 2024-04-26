package com.bank.WalletApp.api.controller;

import com.bank.WalletApp.api.dto.UserRequestDto;
import com.bank.WalletApp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/USERS")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get the balance of a user by userId")
    @GetMapping("/{userId}")
    public ResponseEntity<UserRequestDto> getBalanceByUserId(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getUserById(userId));
    }
}
