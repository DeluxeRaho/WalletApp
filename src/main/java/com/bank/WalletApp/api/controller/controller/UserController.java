package com.bank.WalletApp.api.controller.controller;

import com.bank.WalletApp.api.controller.dto.UserRequestDto;
import com.bank.WalletApp.persistence.entity.User;
import com.bank.WalletApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserRequestDto> getUserById(@PathVariable Long id) {
        UserRequestDto userRequestDto = userService.getUserById(id);
        return ResponseEntity.ok(userRequestDto);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody String name,
                        RequestBody Long balance)
}