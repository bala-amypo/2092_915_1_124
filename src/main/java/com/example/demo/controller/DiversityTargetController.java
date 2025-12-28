package com.example.demo.controller;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diversity-target")
public class DiversityTargetController {

    private final DiversityTargetService service;

    @Autowired
    public DiversityTargetController(DiversityTargetService service) {
        this.service = service;
    }

    @PostMapping
    public DiversityTarget create(@RequestBody DiversityTarget target) {
        return service.create(target);
    }

    @GetMapping("/all")
    public List<DiversityTarget> getAll() {
        return service.getAll();
    }

    @GetMapping("/year/{year}")
    public List<DiversityTarget> getByYear(@PathVariable int year) {
        return service.getByYear(year);
    }

    @PutMapping("/deactivate/{id}")
    public DiversityTarget deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
