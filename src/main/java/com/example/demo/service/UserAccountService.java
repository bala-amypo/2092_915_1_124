package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount create(UserAccount user);

    UserAccount findByEmail(String email);
}
