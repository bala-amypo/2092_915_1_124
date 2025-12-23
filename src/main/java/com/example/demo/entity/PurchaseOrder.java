package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "purchase_orders")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String poNumber;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private SpendCategory category;

    @DecimalMin("0.01")
    private BigDecimal amount;

    @PastOrPresent
    private Date dateIssued;

    private String approvedBy;
    private String notes;
}
