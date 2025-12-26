package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier Management")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    @Operation(summary = "Create new supplier")
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    @PutMapping("/{id}/deactivate")
    public Supplier deactivate(@PathVariable Long id) {
        return supplierService.deactivateSupplier(id);
    }
}