package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    @PostMapping
    public PurchaseOrder create(@RequestBody PurchaseOrder po) {
        return service.createPurchaseOrder(po);
    }

    @GetMapping("/supplier/{id}")
    public List<PurchaseOrder> bySupplier(@PathVariable Long id) {
        return service.getOrdersBySupplier(id);
    }
}
