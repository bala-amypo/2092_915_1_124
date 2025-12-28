package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    @Autowired
    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityTarget create(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getAll() {
        return repository.findAll();
    }

    @Override
    public List<DiversityTarget> getActive() {
        return repository.findByActiveTrue();
    }

    @Override
    public DiversityTarget getByYear(int year) {
        return repository.findByYear(year).orElseThrow(() -> new RuntimeException("Target not found"));
    }

    @Override
    public DiversityTarget deactivate(Long id) {
        DiversityTarget target = repository.findById(id).orElseThrow(() -> new RuntimeException("Target not found"));
        target.setActive(false);
        return repository.save(target);
    }
}
