package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;
import java.util.List;

public interface DiversityTargetService {
    DiversityTarget createTarget(DiversityTarget target);
    List<DiversityTarget> getActiveTargets();
    List<DiversityTarget> getTargetsByYear(Integer year); // Must be plural
    void deactivateTarget(Long id); // Must match this name
}