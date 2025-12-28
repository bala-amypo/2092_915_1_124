package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active = true;

    private float amount;

    @ManyToOne
    @JoinColumn(name = "spend_category_id")
    private SpendCategory spendCategory;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
