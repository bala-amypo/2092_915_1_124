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

    public DiversityClassificationServiceImpl(DiversityClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityClassification createClassification(DiversityClassification classification) {
        return repository.save(classification);
    }

    @Override
    public DiversityClassification updateClassification(Long id, DiversityClassification c) {
        DiversityClassification existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
        existing.setCode(c.getCode());
        existing.setName(c.getName());
        existing.setDescription(c.getDescription());
        existing.setIsActive(c.getIsActive()); // Corrected from setActive/getActive
        return repository.save(existing);
    }

    @Override
    public List<DiversityClassification> getAllClassifications() {
        return repository.findAll();
    }

    @Override
    public DiversityClassification getClassificationById(Long id) { // Exact interface name
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
    }

    @Override
    public List<DiversityClassification> getActiveClassifications() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public void deactivateClassification(Long id) {
        DiversityClassification dc = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
        dc.setIsActive(false); // Corrected from setActive
        repository.save(dc);
    }
}