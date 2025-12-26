package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "diversity_targets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer targetYear;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private DiversityClassification classification;

    private Double targetPercentage;

    private Boolean active = true;
}