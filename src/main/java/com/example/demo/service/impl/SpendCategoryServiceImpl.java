package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.SpendCategory;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.SpendCategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SpendCategoryServiceImpl implements SpendCategoryService {

    private final SpendCategoryRepository repository;

    @Override
    public SpendCategory createCategory(SpendCategory category) {
        category.setActive(true); // default active
        return repository.save(category);
    }

    @Override
    public List<SpendCategory> getActiveCategories() {
        return repository.findByActiveTrue(); // assumes your repo has this method
    }

    @Override
    public SpendCategory deactivateCategory(Long id) {
        SpendCategory category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
        category.setActive(false);
        return repository.save(category);
    }
}
