package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;
import java.util.List;

public interface DiversityTargetService {

    DiversityTarget create(DiversityTarget target);

    List<DiversityTarget> getByYear(int year);

    void deactivate(Long id);
}
