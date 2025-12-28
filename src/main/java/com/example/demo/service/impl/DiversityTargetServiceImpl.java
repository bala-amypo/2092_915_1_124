package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    @Override
    public DiversityTarget create(DiversityTarget target) {
        target.setActive(true);
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getAll() {
        return repository.findAll();
    }

    @Override
    public List<DiversityTarget> getByYear(int year) {
        return repository.findByTargetYear(year);
    }

    @Override
    public DiversityTarget deactivate(Long id) {
        DiversityTarget target = repository.findById(id).orElseThrow();
        target.setActive(false);
        return repository.save(target);
    }
}
