package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    //     http
    //         // Disable CSRF (JWT-based stateless security)
    //         .csrf(csrf -> csrf.disable())

    //         // Stateless session
    //         .sessionManagement(session ->
    //                 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

    //         // Authorization rules
    //         .authorizeHttpRequests(auth -> auth
    //                 .requestMatchers(
    //                         "/auth/**",
    //                         "/swagger-ui/**",
    //                         "/swagger-ui.html",
    //                         "/v3/api-docs/**"
    //                 ).permitAll()
    //                 .anyRequest().authenticated()
    //         );

    //     return http.build();
    // }

    // // Password encoder (BCrypt)
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    // // Authentication manager
    // @Bean
    // public AuthenticationManager authenticationManager(
    //         AuthenticationConfiguration configuration) throws Exception {
    //     return configuration.getAuthenticationManager();
    // }
}
