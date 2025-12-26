package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // Constructor Injection in exact order [cite: 65, 472]
    public UserAccountServiceImpl(UserAccountRepository userRepository, 
                                  PasswordEncoder passwordEncoder, 
                                  JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserAccount register(UserAccount user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists"); [cite: 6, 67, 472]
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); [cite: 95, 473]
        return userRepository.save(user);
    }

    @Override
    public String login(String email, String password) {
        UserAccount user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UnauthorizedException("Invalid credentials")); [cite: 69, 473]
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("Invalid credentials"); [cite: 69, 473]
        }
        return jwtUtil.generateToken(user.getEmail()); [cite: 473, 486]
    }
}