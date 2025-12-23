package com.example.demo.service;

import com.example.demo.entity.SpendCategory;
import java.util.List;

public interface SpendCategoryService {

    SpendCategory createCategory(SpendCategory category);

    List<SpendCategory> getAllCategories();

    List<SpendCategory> getActiveCategories();

    SpendCategory updateCategory(Long id, SpendCategory categoryDetails);

    void deleteCategory(Long id);
}
