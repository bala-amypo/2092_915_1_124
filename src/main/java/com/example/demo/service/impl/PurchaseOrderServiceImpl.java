package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    // THIS CONSTRUCTOR IS REQUIRED BY TESTS
    public PurchaseOrderServiceImpl(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PurchaseOrder> getAll() {
        return repository.findAll();
    }

    @Override
    public List<PurchaseOrder> getActive() {
        return repository.findByActiveTrue();
    }

    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return repository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder deactivate(Long id) {
        PurchaseOrder po = repository.findById(id).orElseThrow();
        po.setActive(false);
        return repository.save(po);
    }
}
