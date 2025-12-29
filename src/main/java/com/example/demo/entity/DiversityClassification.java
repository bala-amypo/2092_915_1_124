package com.example.demo.entity;

import java.time.LocalDateTime;

public class DiversityClassification {

    private Long id;
    private String name;
    private boolean active = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String code;

    public DiversityClassification() {}

    public DiversityClassification(Long id, String name, boolean active, String code) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.code = code;
    }

    public void preSave() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
