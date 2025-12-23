package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.service.DiversityClassificationService;

@RestController
@RequestMapping("/api/diversity-classifications")
@RequiredArgsConstructor
public class DiversityClassificationController {

    private final DiversityClassificationService service;

    @PostMapping
    public DiversityClassification create(@RequestBody DiversityClassification dc) {
        return service.createClassification(dc);
    }

    @GetMapping("/active")
    public List<DiversityClassification> getActive() {
        return service.getActiveClassifications();
    }
}
