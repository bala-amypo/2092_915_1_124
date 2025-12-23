package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;

@Service
@RequiredArgsConstructor
public class DiversityClassificationServiceImpl
        implements DiversityClassificationService {

    private final DiversityClassificationRepository repository;

    @Override
    public DiversityClassification createClassification(DiversityClassification dc) {
        dc.setActive(true);
        return repository.save(dc);
    }

    @Override
    public List<DiversityClassification> getActiveClassifications() {
        return repository.findByActiveTrue();
    }
}
