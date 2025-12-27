package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount register(UserAccount user);   // matches controller
    UserAccount login(String email, String password);  // matches controller
    List<UserAccount> getAll();
}
