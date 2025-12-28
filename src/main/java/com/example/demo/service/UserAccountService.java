package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount create(UserAccount user);
    UserAccount login(String email, String password);
    List<UserAccount> getAll();
}
