package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "suppliers")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; [cite: 381]

    @Column(nullable = false, unique = true)
    private String name; [cite: 381, 383]

    @Column(unique = true)
    private String registrationNumber; [cite: 381]

    @Column(nullable = false, unique = true)
    private String email; [cite: 381, 383]

    private String phone; [cite: 381]
    private String address; [cite: 381]
    private Boolean isActive = true; [cite: 382]

    @ManyToMany
    @JoinTable(name = "supplier_classifications")
    private List<DiversityClassification> diversityClassifications; [cite: 382]

    private LocalDateTime createdAt; [cite: 382]
    private LocalDateTime updatedAt; [cite: 382]

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now(); [cite: 384]
    }
}