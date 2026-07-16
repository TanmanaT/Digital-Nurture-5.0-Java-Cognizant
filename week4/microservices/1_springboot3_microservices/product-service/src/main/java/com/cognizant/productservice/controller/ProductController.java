package com.cognizant.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Map<String, Object> getProduct(@PathVariable Long id) {
        return Map.of(
            "id", id,
            "name", "Premium Laptop",
            "price", 1200.00
        );
    }
}
