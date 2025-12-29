package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseOrder {

    private Long id;
    private String poNumber;
    private BigDecimal amount;
    private LocalDate dateIssued;
    private Supplier supplier;
    private SpendCategory category;
    private String notes;

    // getters & setters
}
