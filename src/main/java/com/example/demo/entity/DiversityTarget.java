package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_target")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "target_year", nullable = false)
    private int year;

    private double percentage;

    private boolean active = true;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
    