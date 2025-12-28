package com.example.demo.service;

import com.example.demo.entity.DiversityClassification;
import java.util.List;

public interface DiversityClassificationService {
    DiversityClassification create(DiversityClassification obj);
    List<DiversityClassification> getActive();
    List<DiversityClassification> getAll();
    DiversityClassification deactivate(Long id);
}
