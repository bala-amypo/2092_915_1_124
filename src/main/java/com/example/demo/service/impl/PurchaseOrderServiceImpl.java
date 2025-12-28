package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    @Override
    public PurchaseOrder create(PurchaseOrder order) {
        order.setActive(true);
        return repository.save(order);
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
    public PurchaseOrder deactivate(Long id) {
        PurchaseOrder order = repository.findById(id).orElseThrow();
        order.setActive(false);
        return repository.save(order);
    }
}
