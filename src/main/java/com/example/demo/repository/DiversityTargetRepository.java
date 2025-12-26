package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {
    // Finds all targets where active = true
    List<DiversityTarget> findByActiveTrue();

    // Finds targets by year
    List<DiversityTarget> findByTargetYear(Integer targetYear);

    // Used for validation logic
    Optional<DiversityTarget> findByTargetYearAndClassificationId(Integer year, Long classificationId);
}