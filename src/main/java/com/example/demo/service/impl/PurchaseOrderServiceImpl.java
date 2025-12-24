package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private final PurchaseOrderRepository poRepo;
    private final SupplierRepository supplierRepo;
    private final SpendCategoryRepository categoryRepo;

    // Strict constructor order for testing [cite: 278, 306]
    public PurchaseOrderServiceImpl(PurchaseOrderRepository poRepo, 
                                   SupplierRepository supplierRepo, 
                                   SpendCategoryRepository categoryRepo) {
        this.poRepo = poRepo;
        this.supplierRepo = supplierRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder order) {
        if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be > 0"); // [cite: 164]
        }
        return poRepo.save(order);
    }

    @Override
    public List<PurchaseOrder> getOrdersBySupplier(Long supplierId) {
        return poRepo.findBySupplierId(supplierId); // [cite: 246]
    }

    @Override
    public List<PurchaseOrder> getOrdersByCategory(Long categoryId) {
        return poRepo.findByCategoryId(categoryId); // [cite: 247]
    }
}