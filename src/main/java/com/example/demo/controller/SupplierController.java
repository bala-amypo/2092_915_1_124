package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;

import java.util.List;

public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    public Supplier getSupplierById(Long id) {
        return supplierService.getSupplierById(id);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    public void deactivateSupplier(Long id) {
        supplierService.deactivateSupplier(id);
    }
}
