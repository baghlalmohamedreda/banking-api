package com.bank.bankingapi.service;
import com.bank.bankingapi.repository.UserRepository;
import com.bank.bankingapi.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public User createUser(User user){
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }


}
