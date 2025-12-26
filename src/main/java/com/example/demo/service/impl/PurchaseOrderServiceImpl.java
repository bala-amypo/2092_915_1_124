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
@Transactional [cite: 258]
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private final PurchaseOrderRepository poRepo;
    private final SupplierRepository supplierRepo;
    private final SpendCategoryRepository categoryRepo;

    // Strict constructor order: PO Repo, Supplier Repo, Category Repo [cite: 278]
    public PurchaseOrderServiceImpl(PurchaseOrderRepository poRepo, 
                                   SupplierRepository supplierRepo, 
                                   SpendCategoryRepository categoryRepo) {
        this.poRepo = poRepo;
        this.supplierRepo = supplierRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder order) { [cite: 246, 278]
        if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be > 0"); [cite: 164, 304]
        }
        return poRepo.save(order);
    }

    @Override
    public List<PurchaseOrder> getOrdersBySupplier(Long supplierId) { [cite: 246, 279]
        return poRepo.findBySupplierId(supplierId);
    }

    @Override
    public List<PurchaseOrder> getOrdersByCategory(Long categoryId) { [cite: 247, 280]
        return poRepo.findByCategoryId(categoryId);
    }
}