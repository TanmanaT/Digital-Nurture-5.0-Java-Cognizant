package com.cognizant.billingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @GetMapping("/{customerId}")
    public Map<String, Object> getBillingInfo(@PathVariable Long customerId) {
        return Map.of(
            "customerId", customerId,
            "balanceDue", 450.75,
            "dueDate", "2026-08-01"
        );
    }
}
