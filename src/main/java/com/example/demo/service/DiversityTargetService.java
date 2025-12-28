package com.example.demo.service;

import com.example.demo.entity.DiversityClassification;
import java.util.List;

public interface DiversityClassificationService {

    DiversityClassification createClassification(DiversityClassification classification);

    List<DiversityClassification> getActiveClassifications();

    List<DiversityClassification> getAll();

    DiversityClassification deactivateClassification(Long id);
}
