package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import java.util.List;
import java.util.Optional;

public interface DiversityTargetRepository {

    DiversityTarget save(DiversityTarget target);

    Optional<DiversityTarget> findById(Long id);

    List<DiversityTarget> findAll();

    List<DiversityTarget> findByTargetYear(Integer year);
}
