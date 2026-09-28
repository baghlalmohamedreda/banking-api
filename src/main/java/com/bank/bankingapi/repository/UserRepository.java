package com.bank.bankingapi.repository;
import com.bank.bankingapi.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);


}

