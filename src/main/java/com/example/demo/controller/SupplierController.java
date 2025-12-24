package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier Management") [cite: 453]
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier); [cite: 455]
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAllSuppliers(); [cite: 458]
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        supplierService.deactivateSupplier(id); [cite: 459]
    }
}