package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {
    private final DiversityTargetRepository targetRepo;

    public DiversityTargetServiceImpl(DiversityTargetRepository targetRepo) {
        this.targetRepo = targetRepo;
    }

    @Override
    @Transactional
    public DiversityTarget createTarget(DiversityTarget target) {
        if (target.getTargetPercentage() < 0 || target.getTargetPercentage() > 100) {
            throw new BadRequestException("Percentage must be between 0 and 100");
        }
        return targetRepo.save(target);
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return targetRepo.findByTargetYear(year);
    }
}