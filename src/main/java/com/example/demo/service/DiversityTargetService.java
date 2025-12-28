package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;
import java.util.List;

public interface DiversityTargetService {

    DiversityTarget createTarget(DiversityTarget target);

    // REQUIRED BY CONTROLLER
    default DiversityTarget create(DiversityTarget target) {
        return createTarget(target);
    }

    List<DiversityTarget> getTargetsByYear(int year);

    List<DiversityTarget> getAll();

    DiversityTarget deactivateTarget(Long id);
}
