package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    @Override
    public UserAccount create(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
