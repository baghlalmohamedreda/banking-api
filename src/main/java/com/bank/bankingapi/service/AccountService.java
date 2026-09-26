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
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElse(null);
    }
    public Account updateAccount(Long id,Account newAccount){
        Account account=accountRepository.findById(id).orElse(null);
        if(account==null){
            return null;
        }
        account.setBalance(newAccount.getBalance());
        account.setAccountNumber(newAccount.getAccountNumber());
        account.setOwnerName(newAccount.getOwnerName());
        return accountRepository.save(account);
    }
    public void deleteAccountById(Long id){
        accountRepository.deleteById(id);
    }





}
