package com.example.demo.repository;

import com.example.demo.entity.DiversityClassification;
import java.util.List;
import java.util.Optional;

public interface DiversityClassificationRepository {

    DiversityClassification save(DiversityClassification classification);

    Optional<DiversityClassification> findById(Long id);

    List<DiversityClassification> findAll();

    List<DiversityClassification> findByActiveTrue();
}
