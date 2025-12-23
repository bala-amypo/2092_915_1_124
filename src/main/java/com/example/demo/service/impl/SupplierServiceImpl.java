package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository repository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public List<Supplier> getActiveSuppliers() {
        return repository.findAll().stream()
                .filter(Supplier::isActive)
                .toList();
    }

    @Override
    public Supplier getSupplier(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
        Supplier supplier = getSupplier(id);
        supplier.setName(supplierDetails.getName());
        supplier.setActive(supplierDetails.isActive());
        return repository.save(supplier);
    }

    @Override
    public Supplier deactivateSupplier(Long id) {
        Supplier supplier = getSupplier(id);
        supplier.setActive(false);
        return repository.save(supplier);
    }
}