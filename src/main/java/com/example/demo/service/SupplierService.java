package com.example.demo.service;

import com.example.demo.entity.Supplier;
import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    Supplier updateSupplier(Long id, Supplier supplierDetails);

    List<Supplier> getAllSuppliers();

    Supplier getSupplier(Long id);

    Supplier deactivateSupplier(Long id); // must return Supplier
}
