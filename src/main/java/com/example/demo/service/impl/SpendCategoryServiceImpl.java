package com.example.demo.service.impl;

import com.example.demo.entity.SpendCategory;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.SpendCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpendCategoryServiceImpl implements SpendCategoryService {

    private final SpendCategoryRepository repository;

    @Autowired
    public SpendCategoryServiceImpl(SpendCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SpendCategory create(SpendCategory category) {
        return repository.save(category);
    }

    @Override
    public List<SpendCategory> getAll() {
        return repository.findAll();
    }

    @Override
    public List<SpendCategory> getActive() {
        return repository.findByActiveTrue();
    }

    @Override
    public SpendCategory deactivate(Long id) {
        SpendCategory category = repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setActive(false);
        return repository.save(category);
    }
}
