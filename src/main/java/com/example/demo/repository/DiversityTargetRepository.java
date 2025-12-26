package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {
    // Required to support the getActiveTargets service call
    List<DiversityTarget> findByActiveTrue();
    
    // Required to support the getTargetsByYear service call
    List<DiversityTarget> findByTargetYear(Integer targetYear);
}