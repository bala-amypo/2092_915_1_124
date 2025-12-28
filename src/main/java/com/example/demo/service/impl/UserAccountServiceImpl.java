package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount create(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public List<UserAccount> getAll() {
        return repository.findAll();
    }

    @Override
    public List<UserAccount> getActive() {
        return repository.findByActiveTrue();
    }

    @Override
    public UserAccount deactivate(Long id) {
        UserAccount user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(false);
        return repository.save(user);
    }
}
