package com.bank.bankingapi.controller;

import com.bank.bankingapi.entity.Account;
import com.bank.bankingapi.service.AccountService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


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
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Account account=accountService.getAccountById(id);
        if(account==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id,@RequestBody Account newAccount){
        Account updateAccount=accountService.updateAccount(id,newAccount);
        if(updateAccount==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateAccount);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
    }



}
