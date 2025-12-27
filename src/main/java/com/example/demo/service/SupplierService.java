package com.example.demo.service;

import com.example.demo.entity.Supplier;
import java.util.List;

public interface SupplierService {
    Supplier create(Supplier supplier);
    List<Supplier> getAll();
    void deactivateSupplier(Long id);
}
