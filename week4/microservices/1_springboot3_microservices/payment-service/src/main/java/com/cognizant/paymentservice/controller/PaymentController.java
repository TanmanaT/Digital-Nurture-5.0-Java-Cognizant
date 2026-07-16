package com.cognizant.paymentservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/charge")
    @CircuitBreaker(name = "paymentGateway", fallbackMethod = "chargeFallback")
    public Map<String, Object> chargeCard(@RequestParam Double amount, @RequestParam(defaultValue = "false") boolean simulateDelay) throws Exception {
        if (simulateDelay) {
            logger.info("Simulating slow third-party payment gateway latency...");
            Thread.sleep(4000); // Wait 4 seconds to trigger circuit breaker
        }
        return Map.of(
            "status", "success",
            "amountCharged", amount,
            "transactionId", "TXN-" + System.currentTimeMillis()
        );
    }

    public Map<String, Object> chargeFallback(Double amount, boolean simulateDelay, Throwable t) {
        logger.warn("Circuit Breaker triggered! Executing fallback logic for payment charging. Reason: {}", t.getMessage());
        return Map.of(
            "status", "fallback_failed",
            "message", "Payment gateway is currently slow or down. Please try again later.",
            "amountRequested", amount
        );
    }
}
