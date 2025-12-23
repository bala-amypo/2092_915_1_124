package com.example.demo.service;

import com.example.demo.entity.SpendCategory;
import java.util.List;

public interface SpendCategoryService {

    SpendCategory createCategory(SpendCategory category);

    SpendCategory updateCategory(Long id, SpendCategory categoryDetails);

    List<SpendCategory> getAllCategories();

    List<SpendCategory> getActiveCategories();
}
