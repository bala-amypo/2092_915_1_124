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
                .filter(Supplier::isActive) // fixed method
                .toList();
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
        Supplier supplier = repository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setName(supplierDetails.getName());
        supplier.setActive(supplierDetails.isActive()); // fixed method
        return repository.save(supplier);
    }

    @Override
    public Supplier deactivateSupplier(Long id) {
        Supplier supplier = repository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setActive(false); // mark as inactive
        return repository.save(supplier);
    }
}
