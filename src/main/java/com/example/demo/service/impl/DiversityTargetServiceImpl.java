package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getActiveTargets() {
        // This name must match the interface signature
        return repository.findByActiveTrue();
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        // Matches interface: plural 'Targets' and 'Integer' wrapper
        return repository.findByTargetYear(year);
    }

    @Override
    public void deactivateTarget(Long id) {
        // Matches interface: 'deactivateTarget'
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Target not found with id: " + id));
        target.setActive(false);
        repository.save(target);
    }
}