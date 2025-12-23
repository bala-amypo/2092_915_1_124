package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Supplier getSupplier(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }
}
