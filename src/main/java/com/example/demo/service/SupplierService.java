package com.example.demo.service;

import com.example.demo.entity.Supplier;
import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    List<Supplier> getActiveSuppliers();

    Supplier getSupplier(Long id);

    Supplier updateSupplier(Long id, Supplier supplierDetails);

    Supplier deactivateSupplier(Long id);
}
