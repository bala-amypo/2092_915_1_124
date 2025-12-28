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
    public List<PurchaseOrder> findAll() {
        return repository.findAll();
    }

    @Override
    public void deactivate(Long id) {
        PurchaseOrder order = repository.findById(id).orElseThrow();
        order.setActive(false);
        repository.save(order);
    }
}
