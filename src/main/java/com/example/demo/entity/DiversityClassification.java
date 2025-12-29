package com.example.demo.entity;

public class DiversityClassification {

    private Long id;
    private String code;
    private Boolean active;

    public void preSave() {
        if (active == null) active = true;
    }

    public void setCode(String code) {
        this.code = code.toUpperCase();
    }

    // getters & setters
}
