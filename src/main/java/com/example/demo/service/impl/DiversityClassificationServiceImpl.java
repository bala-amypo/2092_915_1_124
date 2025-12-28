package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<DiversityClassification> getAll() {
        return repository.findAll();
    }

    @Override
    public List<DiversityClassification> getActiveClassifications() {
        return repository.findByActiveTrue();
    }
}
