package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/spend-categories")
public class SpendCategoryController {

    private final SpendCategoryService service;

    @Autowired
    public SpendCategoryController(SpendCategoryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public SpendCategory create(@RequestBody SpendCategory category) {
        return service.create(category);
    }

    @GetMapping("/all")
    public List<SpendCategory> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<SpendCategory> getActive() {
        return service.getActive();
    }

    @PutMapping("/deactivate/{id}")
    public SpendCategory deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
