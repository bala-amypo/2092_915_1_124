package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityTarget create(DiversityTarget target) {
        target.setActive(true);
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getByYear(int year) {
        return repository.findByYear(year);
    }

    @Override
    public void deactivate(Long id) {
        DiversityTarget target = repository.findById(id).orElseThrow();
        target.setActive(false);
        repository.save(target);
    }
}
