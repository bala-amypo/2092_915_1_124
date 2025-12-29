package com.example.demo.entity;

public class DiversityTarget {

    private Long id;
    private Integer targetYear;
    private boolean active = true;
    private double targetPercentage;
    private DiversityClassification classification;

    public DiversityTarget() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getTargetYear() { return targetYear; }
    public void setTargetYear(Integer targetYear) { this.targetYear = targetYear; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(double targetPercentage) { this.targetPercentage = targetPercentage; }

    public DiversityClassification getClassification() { return classification; }
    public void setClassification(DiversityClassification classification) { this.classification = classification; }

    public void preSave() {
        // Example pre-save logic
        if (classification != null && classification.getActive() == false) {
            classification.setActive(true);
        }
    }
}
