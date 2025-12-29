package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseOrder {

    private Long id;
    private Supplier supplier;
    private SpendCategory category;
    private BigDecimal amount;
    private String poNumber;
    private LocalDate dateIssued;
    private String notes;

    public PurchaseOrder() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }

    public SpendCategory getCategory() { return category; }
    public void setCategory(SpendCategory category) { this.category = category; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }

    public LocalDate getDateIssued() { return dateIssued; }
    public void setDateIssued(LocalDate dateIssued) { this.dateIssued = dateIssued; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
