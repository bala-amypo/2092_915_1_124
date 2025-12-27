package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    @Override
    public Supplier create(Supplier supplier) {
        supplier.setActive(true); // ✅ FIXED
        return repository.save(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return repository.findAll();
    }

    @Override
    public void deactivate(Long id) {
        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setActive(false); // ✅ FIXED
        repository.save(supplier);
    }
}
