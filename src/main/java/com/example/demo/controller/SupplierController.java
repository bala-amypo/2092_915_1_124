package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
@CrossOrigin
public class SupplierController {

    private final SupplierService service;

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return service.create(supplier);
    }

    @GetMapping
    public List<Supplier> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<Supplier> getActive() {
        return service.getActive();
    }

    @PutMapping("/{id}/deactivate")
    public Supplier deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
