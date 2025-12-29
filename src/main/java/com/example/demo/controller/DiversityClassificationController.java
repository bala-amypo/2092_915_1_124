package com.example.demo.controller;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.service.DiversityClassificationService;

import java.util.List;

public class DiversityClassificationController {

    private final DiversityClassificationService service;

    public DiversityClassificationController(DiversityClassificationService service) {
        this.service = service;
    }

    public DiversityClassification createClassification(
            DiversityClassification classification) {
        return service.createClassification(classification);
    }

    public List<DiversityClassification> getAllClassifications() {
        return service.getAllClassifications();
    }

    public void deactivateClassification(Long id) {
        service.deactivateClassification(id);
    }
}
