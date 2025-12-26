package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Data @Table(name = "suppliers")
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; [cite: 73]

    @Column(nullable = false, unique = true)
    private String name; [cite: 73, 75]

    @Column(nullable = false, unique = true)
    private String registrationNumber; [cite: 73, 304]

    @Column(nullable = false, unique = true)
    private String email; [cite: 73, 75]

    private String phone; [cite: 73]
    private String address; [cite: 73]
    private Boolean isActive = true; [cite: 74]

    @ManyToMany
    @JoinTable(name = "supplier_classifications")
    private List<DiversityClassification> diversityClassifications; [cite: 74]

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); } [cite: 76]
}