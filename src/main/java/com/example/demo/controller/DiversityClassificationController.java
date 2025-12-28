package com.example.demo.controller;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.service.DiversityClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diversity-classifications")
@RequiredArgsConstructor
@CrossOrigin
public class DiversityClassificationController {

    private final DiversityClassificationService service;

    @PostMapping
    public DiversityClassification create(@RequestBody DiversityClassification classification) {
        return service.create(classification);
    }

    @GetMapping
    public List<DiversityClassification> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<DiversityClassification> getActive() {
        return service.getActive();
    }
}
