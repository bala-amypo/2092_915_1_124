package com.example.demo.entity;

public class DiversityTarget {

    private Long id;
    private Integer targetYear;
    private DiversityClassification classification;
    private Double targetPercentage;
    private Boolean active;

    public void preSave() {
        if (active == null) active = true;
    }

    // getters & setters
}
