package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Supplier {

    private Long id;
    private String name;
    private boolean isActive = true;
    private String email;
    private String registrationNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<DiversityClassification> diversityClassifications = new ArrayList<>();

    public Supplier() {}

    // ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Active flag
    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean active) { this.isActive = active; }

    // Email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Registration Number
    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    // Created/Updated timestamps
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void prePersist() { this.createdAt = LocalDateTime.now(); }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // Diversity classifications
    public List<DiversityClassification> getDiversityClassifications() { return diversityClassifications; }
    public void setDiversityClassifications(List<DiversityClassification> diversityClassifications) {
        this.diversityClassifications = diversityClassifications;
    }

    public void addDiversityClassification(DiversityClassification classification) {
        this.diversityClassifications.add(classification);
    }
}
