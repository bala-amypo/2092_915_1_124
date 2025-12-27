package com.example.demo.service;

import com.example.demo.entity.DiversityClassification;
import java.util.List;

public interface DiversityClassificationService {
    DiversityClassification create(DiversityClassification classification);
    List<DiversityClassification> getAll();
}
