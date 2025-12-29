package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import java.util.Optional;

public interface UserAccountRepository {

    UserAccount save(UserAccount user);

    Optional<UserAccount> findByEmail(String email);

    boolean existsByEmail(String email);
}
