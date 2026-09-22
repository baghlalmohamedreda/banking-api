package com.bank.bankingapi.service;

import com.bank.bankingapi.repository.AccountRepository;
import org.springframework.stereotype.Service;
import com.bank.bankingapi.entity.Account;
import java.util.List;
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

}
