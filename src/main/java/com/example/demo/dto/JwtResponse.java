package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token; [cite: 498]
    private Long userid; [cite: 498]
    private String email; [cite: 498]
    private String role; [cite: 498]
}