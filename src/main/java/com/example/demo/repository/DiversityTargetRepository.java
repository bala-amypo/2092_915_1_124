package com.example.demo.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DiversityTarget;

public interface DiversityTargetRepository
        extends JpaRepository<DiversityTarget, Long> {

    List<DiversityTarget> findByActiveTrue();
    Optional<DiversityTarget> findByTargetYear(int year);
}
