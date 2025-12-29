package com.example.demo.entity;

import java.math.BigDecimal;

public class PurchaseOrder {

    private Long id;
    private Supplier supplier;
    private SpendCategory category;
    private BigDecimal amount;

    public PurchaseOrder() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public SpendCategory getCategory() {
        return category;
    }

    public void setCategory(SpendCategory category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
