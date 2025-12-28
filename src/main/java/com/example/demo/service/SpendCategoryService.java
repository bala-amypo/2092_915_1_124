package com.example.demo.service;

import com.example.demo.entity.SpendCategory;
import java.util.List;

public interface SpendCategoryService {
    SpendCategory create(SpendCategory category);
    List<SpendCategory> getAll();
    List<SpendCategory> getActive();
    SpendCategory deactivate(Long id);
}
