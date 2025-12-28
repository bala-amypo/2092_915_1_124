package com.example.demo.service;

import com.example.demo.entity.SpendCategory;
import java.util.List;

public interface SpendCategoryService {
    SpendCategory create(SpendCategory category);
    List<SpendCategory> getActive();
    List<SpendCategory> getAll();
    SpendCategory deactivate(Long id);
}
