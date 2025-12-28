package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService service;

    @Autowired
    public AuthController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public UserAccount create(@RequestBody UserAccount user) {
        return service.create(user);
    }

    @GetMapping("/all")
    public List<UserAccount> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<UserAccount> getActive() {
        return service.getActive();
    }

    @PutMapping("/deactivate/{id}")
    public UserAccount deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
