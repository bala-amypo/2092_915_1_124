package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService service;

    @Autowired
    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Supplier create(@RequestBody Supplier supplier) {
        return service.create(supplier);
    }

    @GetMapping("/all")
    public List<Supplier> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<Supplier> getActive() {
        return service.getActive();
    }

    @PutMapping("/deactivate/{id}")
    public Supplier deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
