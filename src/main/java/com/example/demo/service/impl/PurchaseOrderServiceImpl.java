package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private final PurchaseOrderRepository poRepo;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository poRepo) {
        this.poRepo = poRepo;
    }

    @Override
    @Transactional
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        if (po.getAmount() == null || po.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be positive");
        }
        if (po.getDateIssued() != null && po.getDateIssued().after(new Date())) {
            throw new BadRequestException("Date cannot be in the future");
        }
        return poRepo.save(po);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return poRepo.findBySupplier_Id(supplierId);
    }
}