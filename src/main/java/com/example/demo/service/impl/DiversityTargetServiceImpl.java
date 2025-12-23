package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;

@Service
@RequiredArgsConstructor
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        target.setActive(true);
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getActiveTargets() {
        return repository.findByActiveTrue();
    }
}
