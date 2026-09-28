package com.bank.bankingapi.controller;
import com.bank.bankingapi.entity.User;
import com.bank.bankingapi.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User createdUser=userService.createUser(user);
        if(createdUser==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

    }
}
