package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiversityClassificationServiceImpl implements DiversityClassificationService {

    private final DiversityClassificationRepository repository;

    @Override
    public DiversityClassification create(DiversityClassification classification) {
        classification.setActive(true);
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
}
