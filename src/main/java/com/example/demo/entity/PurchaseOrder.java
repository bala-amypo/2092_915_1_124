package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private boolean active = true;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private SpendCategory spendCategory;

    public PurchaseOrder() {}

    @PrePersist
    public void prePersist() {
        this.active = true;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public boolean isActive() { return active; }
    public Supplier getSupplier() { return supplier; }
    public SpendCategory getSpendCategory() { return spendCategory; }

    public void setId(Long id) { this.id = id; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setActive(boolean active) { this.active = active; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public void setSpendCategory(SpendCategory spendCategory) { this.spendCategory = spendCategory; }
}
