package com.example.demo.repository;

import com.example.demo.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderRepository {

    PurchaseOrder save(PurchaseOrder purchaseOrder);

    List<PurchaseOrder> findAll();

    List<PurchaseOrder> findBySupplier_Id(Long supplierId);
}
