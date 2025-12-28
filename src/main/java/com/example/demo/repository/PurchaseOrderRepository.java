package com.example.demo.repository;

import com.example.demo.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    // Fetch all orders by SpendCategory id
    List<PurchaseOrder> findBySpendCategory_Id(Long id);

    // Fetch only active orders (optional)
    List<PurchaseOrder> findByActiveTrue();
}
