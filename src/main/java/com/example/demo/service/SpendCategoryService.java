package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.SpendCategory;

public interface SpendCategoryService {
    SpendCategory createCategory(SpendCategory category);
    List<SpendCategory> getActiveCategories();
}
