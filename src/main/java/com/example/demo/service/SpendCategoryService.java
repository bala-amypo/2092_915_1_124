package com.example.demo.service;

import com.example.demo.entity.SpendCategory;

import java.util.List;

public interface SpendCategoryService {

    SpendCategory createCategory(SpendCategory category);

    // REQUIRED BY TEST 20
    List<SpendCategory> getAllCategories();

    // REQUIRED BY CONTROLLER
    List<SpendCategory> getActiveCategories();

    void deactivateCategory(Long id);
}
