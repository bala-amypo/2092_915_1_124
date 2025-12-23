package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder createOrder(PurchaseOrder po);
    List<PurchaseOrder> getOrdersByCategory(Long categoryId);
}
