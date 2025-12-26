package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier Management") [cite: 145, 181]
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService; [cite: 474]
    }

    @PostMapping
    @Operation(summary = "Create new supplier") [cite: 181]
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier); [cite: 113, 147]
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAllSuppliers(); [cite: 116, 150]
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Long id) {
        return supplierService.getSupplierById(id); [cite: 115, 149]
    }

    @PutMapping("/{id}/deactivate")
    public Supplier deactivate(@PathVariable Long id) {
        return supplierService.deactivateSupplier(id); [cite: 117, 151]
    }
}