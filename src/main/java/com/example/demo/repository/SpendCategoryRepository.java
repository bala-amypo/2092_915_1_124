package com.example.demo.repository;

import com.example.demo.entity.SpendCategory;
import java.util.List;
import java.util.Optional;

public interface SpendCategoryRepository {

    SpendCategory save(SpendCategory category);

    Optional<SpendCategory> findById(Long id);

    List<SpendCategory> findAll();

    List<SpendCategory> findByActiveTrue();
}
