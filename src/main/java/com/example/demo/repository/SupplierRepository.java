package com.example.demo.repository;

import com.example.demo.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByIsActiveTrue(); [cite: 52]
    Optional<Supplier> findByEmail(String email); [cite: 392]
    boolean existsByEmail(String email);
}