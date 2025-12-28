package com.example.demo.controller;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/diversity-classification")
public class DiversityClassificationController {

    private final DiversityClassificationService service;

    public DiversityClassificationController(DiversityClassificationService service) {
        this.service = service;
    }

    @PostMapping
    public DiversityClassification create(@RequestBody DiversityClassification obj) {
        // Correct method call
        return service.create(obj);
    }

    @GetMapping("/active")
    public List<DiversityClassification> getActive() {
        // Correct method call
        return service.getActive();
    }
}
