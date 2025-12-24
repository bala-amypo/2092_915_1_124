package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepo;

    public SupplierServiceImpl(SupplierRepository supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findByIsActiveTrue();
    }

    @Override
    public void deactivateSupplier(Long id) {
        Supplier supplier = supplierRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        supplier.setIsActive(false);
        supplierRepo.save(supplier);
    }
}