package com.example.demo.entity;

public class DiversityTarget {

    private Long id;
    private Integer targetYear;
    private double targetPercentage;
    private boolean active = true;
    private DiversityClassification classification;

    public DiversityTarget() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getTargetYear() { return targetYear; }
    public void setTargetYear(Integer targetYear) { this.targetYear = targetYear; }

    public double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(double targetPercentage) { this.targetPercentage = targetPercentage; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public DiversityClassification getClassification() { return classification; }
    public void setClassification(DiversityClassification classification) { this.classification = classification; }
}
