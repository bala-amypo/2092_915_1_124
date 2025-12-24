package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "diversity_classifications")
@Data
public class DiversityClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code; // e.g., MBE, WBE

    @Column(nullable = false)
    private String name;

    private String description;
    private Boolean isActive = true;
}