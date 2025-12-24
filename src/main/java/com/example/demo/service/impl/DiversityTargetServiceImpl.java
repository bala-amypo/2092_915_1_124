package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;
    private final DiversityClassificationRepository classificationRepository;

    // Requirement: Constructor-based dependency injection [cite: 281, 306]
    public DiversityTargetServiceImpl(DiversityTargetRepository repository, 
                                     DiversityClassificationRepository classificationRepository) {
        this.repository = repository;
        this.classificationRepository = classificationRepository;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        // Business Rule: Validate unique active target per year and classification [cite: 180, 281]
        repository.findByTargetYearAndClassificationId(target.getTargetYear(), target.getClassification().getId())
            .ifPresent(existing -> {
                if (existing.getIsActive()) {
                    throw new RuntimeException("Active target already exists for this year and classification");
                }
            });
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getActiveTargets() {
        // Requirement: Retrieve only active diversity targets [cite: 220, 282]
        return repository.findByActiveTrue();
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Target not found"));
        
        // Fix: Use setIsActive(false) to match the entity field name 'isActive' [cite: 176]
        target.setIsActive(false); 
        repository.save(target);
    }
}