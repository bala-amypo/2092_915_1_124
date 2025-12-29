package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;

import java.util.List;

public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder order) {
        return service.createPurchaseOrder(order);
    }

    public List<PurchaseOrder> getOrdersBySupplier(Long supplierId) {
        return service.getPurchaseOrdersBySupplier(supplierId);
    }
}
