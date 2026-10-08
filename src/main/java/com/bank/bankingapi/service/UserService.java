package com.bank.bankingapi.service;
import com.bank.bankingapi.repository.UserRepository;
import com.bank.bankingapi.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
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
        Optional<User> existingUser=userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            return null;
        }
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
    public User login(String email,String password){
        Optional<User> existingUser=userRepository.findByEmail(email);
        if(existingUser.isEmpty()){
            return null;
        }
        User user=existingUser.get();
        if(!passwordEncoder.matches(password,user.getPassword())){
            return null;
        }
        return user;
    }



}
