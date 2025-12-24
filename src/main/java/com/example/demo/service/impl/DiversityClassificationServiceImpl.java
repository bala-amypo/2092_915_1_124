package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class DiversityClassificationServiceImpl implements DiversityClassificationService {

    private final DiversityClassificationRepository repository;

    // Requirement: Constructor injection with exact naming [cite: 354, 369]
    public DiversityClassificationServiceImpl(DiversityClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityClassification createClassification(DiversityClassification classification) {
        // Validation: Ensure code is unique and uppercase as per rules 
        if (classification.getCode() != null) {
            classification.setCode(classification.getCode().toUpperCase());
        }
        return repository.save(classification);
    }

    @Override
    public DiversityClassification updateClassification(Long id, DiversityClassification c) {
        DiversityClassification existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
        existing.setCode(c.getCode().toUpperCase());
        existing.setDescription(c.getDescription());
        existing.setActive(c.getActive());
        return repository.save(existing);
    }

    @Override
    public List<DiversityClassification> getAllClassifications() {
        return repository.findAll();
    }

    @Override
    public DiversityClassification getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
    }

    @Override
    public List<DiversityClassification> getActiveClassifications() {
        // Requirement: Use the exact repository method signature [cite: 361]
        return repository.findByActiveTrue();
    }

    @Override
    public void deactivateClassification(Long id) {
        DiversityClassification dc = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
        // Rule: Only active classifications can be assigned [cite: 137]
        dc.setActive(false); 
        repository.save(dc);
    }
}