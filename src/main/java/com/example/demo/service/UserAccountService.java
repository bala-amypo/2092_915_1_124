package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount create(UserAccount userAccount);
    List<UserAccount> getAll();
    List<UserAccount> getActive();
    UserAccount deactivate(Long id);
}
