package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diversity_target")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "target_year", nullable = false)
    private int year;  // renamed to avoid SQL reserved keyword

    @Column(nullable = false)
    private float percentage;

    @Column(nullable = false)
    private boolean active;

    @Column(length = 255)
    private String description;
}
