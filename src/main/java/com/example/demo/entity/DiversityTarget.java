package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private double percentage;
    private boolean active = true;

    public DiversityTarget() {}

    @PrePersist
    public void prePersist() {
        this.active = true;
    }

    public Long getId() { return id; }
    public int getYear() { return year; }
    public double getPercentage() { return percentage; }
    public boolean isActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setYear(int year) { this.year = year; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
    public void setActive(boolean active) { this.active = active; }
}
