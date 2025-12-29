package com.example.demo.entity;

public class DiversityTarget {

    private Long id;
    private Integer targetYear;
    private boolean active = true;

    public DiversityTarget() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(Integer targetYear) {
        this.targetYear = targetYear;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
