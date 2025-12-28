package com.example.demo.controller;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diversity-targets")
@RequiredArgsConstructor
@CrossOrigin
public class DiversityTargetController {

    private final DiversityTargetService service;

    @PostMapping
    public DiversityTarget create(@RequestBody DiversityTarget target) {
        return service.create(target);
    }

    @GetMapping
    public List<DiversityTarget> getAll() {
        return service.getAll();
    }

    @GetMapping("/year/{year}")
    public List<DiversityTarget> getByYear(@PathVariable int year) {
        return service.getByYear(year);
    }

    @PutMapping("/{id}/deactivate")
    public DiversityTarget deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
