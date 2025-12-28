package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spend-categories")
@RequiredArgsConstructor
@CrossOrigin
public class SpendCategoryController {

    private final SpendCategoryService service;

    @PostMapping
    public SpendCategory create(@RequestBody SpendCategory category) {
        return service.create(category);
    }

    @GetMapping
    public List<SpendCategory> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<SpendCategory> getActive() {
        return service.getActive();
    }

    @PutMapping("/{id}/deactivate")
    public SpendCategory deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
