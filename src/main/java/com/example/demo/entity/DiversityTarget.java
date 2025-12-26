package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "diversity_targets")
@Data // Generates setActive(boolean)
public class DiversityTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer targetYear;
    
    @ManyToOne
    private DiversityClassification classification;
    
    private Double targetPercentage;
    
    private Boolean active = true; // Field must be named 'active'
}