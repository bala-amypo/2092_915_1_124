package com.example.demo.controller;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/targets")
public class DiversityTargetController {

    private final DiversityTargetService service;

    public DiversityTargetController(DiversityTargetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DiversityTarget> create(@RequestBody DiversityTarget target) {
        return ResponseEntity.ok(service.createTarget(target));
    }

    @GetMapping("/active")
    public ResponseEntity<List<DiversityTarget>> getActive() {
        return ResponseEntity.ok(service.getAllTargets());
    }
}
