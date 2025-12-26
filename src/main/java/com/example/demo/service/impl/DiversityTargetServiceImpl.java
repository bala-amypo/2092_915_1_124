package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {
    private final DiversityTargetRepository targetRepo;

    public DiversityTargetServiceImpl(DiversityTargetRepository targetRepo) {
        this.targetRepo = targetRepo; [cite: 64, 471]
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        if (target.getTargetPercentage() < 0 || target.getTargetPercentage() > 100) {
            throw new BadRequestException("Percentage must be 0-100"); [cite: 91, 368]
        }
        return targetRepo.save(target); [cite: 137, 472]
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return targetRepo.findByTargetYear(year); [cite: 55, 139]
    }
}