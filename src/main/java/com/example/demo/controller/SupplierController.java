package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier Management", description = "Endpoints for managing supplier data")
public class SupplierController {
    // Controller logic remains the same
}