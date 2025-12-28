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
    public DiversityClassification create(DiversityClassification obj) {
        obj.setActive(true);
        return repository.save(obj);
    }

    @Override
    public List<DiversityClassification> getActive() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<DiversityClassification> getAll() {
        return repository.findAll();
    }

    @Override
    public DiversityClassification deactivate(Long id) {
        DiversityClassification obj = repository.findById(id).orElseThrow();
        obj.setActive(false);
        return repository.save(obj);
    }
}
