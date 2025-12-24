package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "diversity_targets")
@Data
public class DiversityTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer targetYear;
    
    @ManyToOne
    private DiversityClassification classification;

    @Column(precision = 5, scale = 2)
    private BigDecimal targetPercentage; // e.g., 15.00 for 15%

    private Boolean isActive = true;
}