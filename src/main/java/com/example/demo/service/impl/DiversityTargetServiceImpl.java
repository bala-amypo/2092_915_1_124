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
        target.setActive(true); // ✅ FIXED
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getAll() {
        return repository.findAll();
    }

    @Override
    public void deactivate(Long id) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Target not found"));
        target.setActive(false); // ✅ FIXED
        repository.save(target);
    }
}
