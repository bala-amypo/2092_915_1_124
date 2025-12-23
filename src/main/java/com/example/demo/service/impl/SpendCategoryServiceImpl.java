package com.example.demo.service.impl;

import com.example.demo.entity.SpendCategory;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.SpendCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendCategoryServiceImpl implements SpendCategoryService {

    @Autowired
    private SpendCategoryRepository repository;

    @Override
    public SpendCategory createCategory(SpendCategory category) {
        return repository.save(category);
    }

    @Override
    public SpendCategory updateCategory(Long id, SpendCategory categoryDetails) {
        SpendCategory category = repository.findById(id).orElseThrow();
        category.setName(categoryDetails.getName());
        category.setActive(categoryDetails.getActive()); // match entity field
        return repository.save(category);
    }

    @Override
    public List<SpendCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public List<SpendCategory> getActiveCategories() {
        return repository.findByActiveTrue(); // repository must have this method
    }
}
