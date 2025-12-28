package com.example.demo.service.impl;

import com.example.demo.entity.SpendCategory;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.SpendCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpendCategoryServiceImpl implements SpendCategoryService {

    private final SpendCategoryRepository repository;

    @Override
    public SpendCategory create(SpendCategory category) {
        category.setActive(true);
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
        SpendCategory category = repository.findById(id).orElseThrow();
        category.setActive(false);
        return repository.save(category);
    }
}
