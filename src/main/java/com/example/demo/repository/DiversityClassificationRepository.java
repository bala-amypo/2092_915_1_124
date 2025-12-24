package com.example.demo.repository;

import com.example.demo.entity.DiversityClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DiversityClassificationRepository extends JpaRepository<DiversityClassification, Long> {
    Optional<DiversityClassification> findByCode(String code); // Required for validation [cite: 207]
    List<DiversityClassification> findByActiveTrue(); // Required for active filtering [cite: 207]
}