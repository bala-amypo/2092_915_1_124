package com.example.demo.service;

import com.example.demo.entity.DiversityClassification;
import java.util.List;

public interface DiversityClassificationService {

    DiversityClassification create(DiversityClassification classification);

    // REQUIRED BY CONTROLLER
    default DiversityClassification createClassification(
            DiversityClassification classification) {
        return create(classification);
    }

    List<DiversityClassification> getActive();

    // REQUIRED BY CONTROLLER
    default List<DiversityClassification> getActiveClassifications() {
        return getActive();
    }

    List<DiversityClassification> getAll();

    DiversityClassification deactivate(Long id);
}
