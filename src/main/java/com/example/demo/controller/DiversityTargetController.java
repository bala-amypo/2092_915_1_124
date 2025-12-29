package com.example.demo.controller;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;

import java.util.List;

public class DiversityTargetController {

    private final DiversityTargetService service;

    public DiversityTargetController(DiversityTargetService service) {
        this.service = service;
    }

    public DiversityTarget createTarget(DiversityTarget target) {
        return service.createTarget(target);
    }

    public List<DiversityTarget> getAllTargets() {
        return service.getAllTargets();
    }

    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return service.getTargetsByYear(year);
    }

    public void deactivateTarget(Long id) {
        service.deactivateTarget(id);
    }
}
