package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-orders")
@RequiredArgsConstructor
@CrossOrigin
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    @PostMapping
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }

    @GetMapping
    public List<PurchaseOrder> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<PurchaseOrder> getActive() {
        return service.getActive();
    }

    @PutMapping("/{id}/deactivate")
    public PurchaseOrder deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
