package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetService {

    private final DiversityTargetRepository repository;

    public DiversityTargetService(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    public List<DiversityTarget> getActiveTargets() {
        return repository.findByActiveTrue();
    }

    public DiversityTarget saveTarget(DiversityTarget target) {
        return repository.save(target);
    }
}
