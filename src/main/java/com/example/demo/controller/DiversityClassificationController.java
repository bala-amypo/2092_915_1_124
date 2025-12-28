package com.example.demo.controller;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/diversity-classifications")
public class DiversityClassificationController {

    private final DiversityClassificationService service;

    @Autowired
    public DiversityClassificationController(DiversityClassificationService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public DiversityClassification create(@RequestBody DiversityClassification classification) {
        return service.create(classification);
    }

    @GetMapping("/all")
    public List<DiversityClassification> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<DiversityClassification> getActive() {
        return service.getActive();
    }

    @PutMapping("/deactivate/{id}")
    public DiversityClassification deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
