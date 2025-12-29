package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.entity.Supplier;
import com.example.demo.entity.SpendCategory;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.PurchaseOrderService;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepository;
    private final SupplierRepository supplierRepository;
    private final SpendCategoryRepository categoryRepository;

    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository poRepository,
            SupplierRepository supplierRepository,
            SpendCategoryRepository categoryRepository
    ) {
        this.poRepository = poRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder order) {

        if (order.getAmount() == null ||
            order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Invalid amount");
        }

        Supplier supplier = supplierRepository
                .findById(order.getSupplier().getId())
                .orElseThrow();

        SpendCategory category = categoryRepository
                .findById(order.getCategory().getId())
                .orElseThrow();

        if (!supplier.getIsActive()) {
            throw new BadRequestException("Inactive supplier");
        }

        if (!category.getActive()) {
            throw new BadRequestException("Inactive category");
        }

        return poRepository.save(order);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return poRepository.findBySupplier_Id(supplierId);
    }
}
