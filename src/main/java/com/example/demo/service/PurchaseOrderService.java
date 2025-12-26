package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrder save(PurchaseOrder order);

    List<PurchaseOrder> findAll();

    List<PurchaseOrder> findBySupplierId(Long supplierId);

    List<PurchaseOrder> findBySpendCategoryId(Long categoryId);
}
