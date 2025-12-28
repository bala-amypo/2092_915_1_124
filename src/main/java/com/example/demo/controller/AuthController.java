package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService service;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.create(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        UserAccount user = service.login(email, password);
        if (user != null) {
            return jwtUtil.generateToken(user.getEmail());
        }
        throw new RuntimeException("Invalid credentials");
    }
}
