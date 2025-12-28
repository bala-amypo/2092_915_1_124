package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-order")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }

    @GetMapping("/all")
    public List<PurchaseOrder> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<PurchaseOrder> getActive() {
        return service.getActive();
    }

    @PutMapping("/deactivate/{id}")
    public PurchaseOrder deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
