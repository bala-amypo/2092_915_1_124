package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Supplier;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);
    Supplier getSupplier(Long id);
    List<Supplier> getAllSuppliers();
}
