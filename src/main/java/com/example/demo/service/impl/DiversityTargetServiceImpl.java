package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {
    private final DiversityTargetRepository targetRepo;

    public DiversityTargetServiceImpl(DiversityTargetRepository targetRepo) {
        this.targetRepo = targetRepo;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return targetRepo.save(target);
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return targetRepo.findByTargetYear(year);
    }

    @Override
    public List<DiversityTarget> getActiveTargets() {
        return targetRepo.findByIsActiveTrue();
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = targetRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Target not found"));
        target.setIsActive(false);
        targetRepo.save(target);
    }
}