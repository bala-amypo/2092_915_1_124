package com.example.demo.controller;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diversity-targets")
@RequiredArgsConstructor
public class DiversityTargetController {

    private final DiversityTargetService service;

    @PostMapping
    public DiversityTarget create(@RequestBody DiversityTarget target) {
        return service.create(target); // ✅ FIXED
    }

    @GetMapping
    public List<DiversityTarget> getAll() {
        return service.getAll(); // ✅ FIXED
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateTarget(id); // ✅ FIXED
    }
}
