package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        supplier.setActive(true);
        return repository.save(supplier);
    }

    @Override
    public List<Supplier> getActive() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<Supplier> getAll() {
        return repository.findAll();
    }

    @Override
    public Supplier deactivate(Long id) {
        Supplier supplier = repository.findById(id).orElseThrow();
        supplier.setActive(false);
        return repository.save(supplier);
    }
}
