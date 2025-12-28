package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/purchase-order")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseOrder create(@Valid @RequestBody PurchaseOrder order) {
        // Call the correct service method
        return service.create(order);
    }

    @GetMapping
    public List<PurchaseOrder> getAll() {
        // Call the correct service method
        return service.getAll();
    }

    @GetMapping("/by-spend-category/{id}")
    public List<PurchaseOrder> getBySpendCategory(@PathVariable Long id) {
        return service.getBySpendCategoryId(id);
    }

    @PutMapping("/deactivate/{id}")
    public PurchaseOrder deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
