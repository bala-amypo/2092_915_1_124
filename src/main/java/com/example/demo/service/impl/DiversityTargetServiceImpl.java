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
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getAll() {
        return repository.findAll();
    }

    @Override
    public List<DiversityTarget> getByTargetYear(int year) {
        return repository.findByTargetYear(year);
    }

    @Override
    public DiversityTarget update(Long id, DiversityTarget targetDetails) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DiversityTarget not found"));
        target.setTargetYear(targetDetails.getTargetYear());
        target.setTargetValue(targetDetails.getTargetValue());
        target.setDescription(targetDetails.getDescription());
        return repository.save(target);
    }
}
