package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "purchase_orders")
@Data
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; [cite: 391]

    @Column(unique = true)
    private String poNumber; [cite: 391]

    @ManyToOne
    private Supplier supplier; [cite: 391]

    @ManyToOne
    private SpendCategory category; [cite: 391]

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal amount; [cite: 391, 393]

    @PastOrPresent
    private Date dateIssued; [cite: 391, 394]

    private String approvedBy; [cite: 391]
    private String notes; [cite: 391]
}