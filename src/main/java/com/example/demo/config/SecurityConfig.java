package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for Swagger and REST APIs
            .csrf(csrf -> csrf.disable())

            // Disable CORS restrictions
            .cors(cors -> cors.disable())

            // Allow all requests including Swagger and H2
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/swagger-ui.html",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/h2-console/**",
                    "/**"
                ).permitAll()
                .anyRequest().permitAll()
            )

            // Required for H2 console
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            // Disable all authentication mechanisms
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(formLogin -> formLogin.disable());

        return http.build();
    }
}
