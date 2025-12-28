package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiversityClassificationServiceImpl implements DiversityClassificationService {

    private final DiversityClassificationRepository repository;

    @Autowired
    public DiversityClassificationServiceImpl(DiversityClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityClassification create(DiversityClassification classification) {
        return repository.save(classification);
    }

    @Override
    public List<DiversityClassification> getAll() {
        return repository.findAll();
    }

    @Override
    public List<DiversityClassification> getActive() {
        return repository.findByActiveTrue();
    }

    @Override
    public DiversityClassification deactivate(Long id) {
        DiversityClassification classification = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Classification not found"));
        classification.setActive(false);
        return repository.save(classification);
    }
}
