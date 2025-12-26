package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional // Service write operations must be transactional 
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    // Strict constructor injection required for automated testing 
    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getActiveTargets() {
        // This call will now resolve with the updated repository [cite: 251, 282]
        return repository.findByActiveTrue();
    }

    // Ensure other interface methods like getTargetsByYear are implemented here [cite: 447]
}