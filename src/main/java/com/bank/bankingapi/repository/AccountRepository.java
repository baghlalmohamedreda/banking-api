package com.bank.bankingapi.repository;
import com.bank.bankingapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account,Long> {
}
