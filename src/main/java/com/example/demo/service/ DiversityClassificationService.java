package com.example.demo.service;

import com.example.demo.entity.DiversityClassification;
import java.util.List;

public interface DiversityClassificationService {

    List<DiversityClassification> getAllClassifications();

    List<DiversityClassification> getActiveClassifications();

    void deactivateClassification(Long id);
}
