package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Supplier> getActive() {
        return repository.findByActiveTrue();
    }

    @Override
    public Supplier deactivate(Long id) {
        Supplier supplier = repository.findById(id).orElseThrow();
        supplier.setActive(false);
        return repository.save(supplier);
    }
}
