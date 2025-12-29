package com.example.demo.entity;

import java.time.LocalDateTime;

public class UserAccount {

    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public void prePersist() {
        if (role == null) role = "USER";
        createdAt = LocalDateTime.now();
    }

    public UserAccount() {}

    public UserAccount(Long id, String fullName, String email, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // getters & setters
}
