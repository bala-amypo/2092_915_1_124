package com.example.demo.entity;

public class SpendCategory {

    private Long id;
    private String name;
    private Boolean active;

    public void preSave() {
        if (active == null) active = true;
    }

    // getters & setters
}
