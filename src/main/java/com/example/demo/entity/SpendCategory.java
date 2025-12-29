package com.example.demo.entity;

import java.time.LocalDateTime;

public class SpendCategory {
    private Long id;
    private String name;
    private boolean active = true;
    private LocalDateTime createdAt;

    public SpendCategory() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public void preSave() { this.createdAt = LocalDateTime.now(); }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
