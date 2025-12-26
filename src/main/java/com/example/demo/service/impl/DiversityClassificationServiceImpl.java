package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional [cite: 258]
public class DiversityClassificationServiceImpl implements DiversityClassificationService {
    private final DiversityClassificationRepository repository;

    public DiversityClassificationServiceImpl(DiversityClassificationRepository repository) { [cite: 275]
        this.repository = repository;
    }

    @Override
    public DiversityClassification createClassification(DiversityClassification classification) { [cite: 238, 276]
        if (classification.getCode() != null) {
            classification.setCode(classification.getCode().toUpperCase()); [cite: 132]
        }
        return repository.save(classification);
    }

    @Override
    public List<DiversityClassification> getActiveClassifications() { [cite: 238, 276]
        return repository.findByActiveTrue();
    }
}