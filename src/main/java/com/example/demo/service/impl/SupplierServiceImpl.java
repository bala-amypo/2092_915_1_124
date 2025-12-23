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
    private SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        supplier.setActive(true);
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplier(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Supplier deactivateSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setActive(false);
            return supplierRepository.save(supplier);
        }
        return null;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
}
