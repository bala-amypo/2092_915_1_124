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
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(unique = true)
    private String registrationNumber;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;
    private String address;
    private Boolean isActive = true;

    @ManyToMany
    @JoinTable(name = "supplier_classifications")
    private List<DiversityClassification> diversityClassifications;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}