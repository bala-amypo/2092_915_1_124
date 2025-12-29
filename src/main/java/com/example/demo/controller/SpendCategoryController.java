package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;

import java.util.List;

public class SpendCategoryController {

    private final SpendCategoryService service;

    public SpendCategoryController(SpendCategoryService service) {
        this.service = service;
    }

    public SpendCategory createCategory(SpendCategory category) {
        return service.createCategory(category);
    }

    public List<SpendCategory> getAllCategories() {
        return service.getAllCategories();
    }

    public void deactivateCategory(Long id) {
        service.deactivateCategory(id);
    }
}
