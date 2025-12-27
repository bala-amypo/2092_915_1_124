package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.create(supplier); // ✅ FIXED
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAll(); // ✅ FIXED
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        supplierService.deactivateSupplier(id); // ✅ FIXED
    }
}
