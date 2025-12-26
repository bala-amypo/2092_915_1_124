package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {
    // Required: Must return List<DiversityTarget> [cite: 220, 361]
    List<DiversityTarget> findByActiveTrue();

    // Required: Find targets by specific year [cite: 363]
    List<DiversityTarget> findByTargetYear(Integer year);

    // Required: Logic to validate unique active target per year/classification [cite: 219]
    Optional<DiversityTarget> findByTargetYearAndClassificationId(Integer year, Long classificationId);
}