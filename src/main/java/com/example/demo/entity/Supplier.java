package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Supplier {

    private Long id;
    private String name;
    private String email;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<DiversityClassification> diversityClassifications = new HashSet<>();

    public void prePersist() {
        if (isActive == null) isActive = true;
        createdAt = LocalDateTime.now();
    }

    // getters & setters
    // IMPORTANT: return actual set
    public Set<DiversityClassification> getDiversityClassifications() {
        return diversityClassifications;
    }
}
