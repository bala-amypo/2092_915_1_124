package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/spend-category")
public class SpendCategoryController {

    private final SpendCategoryService service;

    public SpendCategoryController(SpendCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public SpendCategory create(@RequestBody SpendCategory category) {
        return service.create(category);
    }

    @GetMapping("/active")
    public List<SpendCategory> getActive() {
        return service.getActive();
    }

    @GetMapping
    public List<SpendCategory> getAll() {
        return service.getAll();
    }

    @PutMapping("/deactivate/{id}")
    public SpendCategory deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
