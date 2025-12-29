package com.example.demo.entity;

import java.time.LocalDateTime;

public class DiversityTarget {
    private Long id;
    private Integer targetYear;
    private boolean active = true;
    private Double targetPercentage;
    private DiversityClassification classification;
    private LocalDateTime createdAt;

    public DiversityTarget() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getTargetYear() { return targetYear; }
    public void setTargetYear(Integer targetYear) { this.targetYear = targetYear; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(Double targetPercentage) { this.targetPercentage = targetPercentage; }

    public DiversityClassification getClassification() { return classification; }
    public void setClassification(DiversityClassification classification) { this.classification = classification; }

    public void preSave() { this.createdAt = LocalDateTime.now(); }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
