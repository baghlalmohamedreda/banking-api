package com.bank.bankingapi.repository;
import com.bank.bankingapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long> {


}

