package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private final PurchaseOrderRepository poRepo;
    private final SupplierRepository supplierRepo;
    private final SpendCategoryRepository categoryRepo;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository poRepo, 
                                   SupplierRepository supplierRepo, 
                                   SpendCategoryRepository categoryRepo) {
        this.poRepo = poRepo;
        this.supplierRepo = supplierRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        if (po.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be > 0");
        }
        return poRepo.save(po);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return poRepo.findBySupplier_Id(supplierId);
    }
}