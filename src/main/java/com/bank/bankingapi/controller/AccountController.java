package com.bank.bankingapi.controller;

import com.bank.bankingapi.entity.Account;
import com.bank.bankingapi.service.AccountService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }
    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id,@RequestBody Account newAccount){
        return accountService.updateAccount(id,newAccount);

    }



}
