package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors() // Enable CORS configuration
            .and()
            .csrf().disable() // Disable CSRF for testing
            .authorizeHttpRequests()
            .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/h2-console/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic(); // Basic auth for other endpoints (optional)
        
        // H2 Console specific config
        http.headers().frameOptions().disable();

        return http.build();
    }
}
