package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.DiversityClassification;

public interface DiversityClassificationService {

    DiversityClassification createClassification(DiversityClassification dc);

    List<DiversityClassification> getActiveClassifications();
}
