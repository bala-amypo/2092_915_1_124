package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {
    // Required for the service to filter active targets 
    List<DiversityTarget> findByActiveTrue();

    // Required for fetching targets by specific year [cite: 363, 482]
    List<DiversityTarget> findByTargetYear(Integer year);

    // Required for business logic validation of unique active targets [cite: 219, 281]
    Optional<DiversityTarget> findByTargetYearAndClassificationId(Integer year, Long classificationId);
}