package com.example.demo.entity;

public class DiversityClassification {

    private Long id;
    private String name;
    private String code; // Added for test usage
    private boolean active = true;

    public DiversityClassification() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    // Added for test usage
    public void preSave() {
        // Optional: implement pre-save logic if needed
    }
}
