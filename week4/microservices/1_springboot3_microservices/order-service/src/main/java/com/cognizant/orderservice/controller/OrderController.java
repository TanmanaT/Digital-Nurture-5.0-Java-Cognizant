package com.cognizant.orderservice.controller;

import com.cognizant.orderservice.client.UserClient;
import com.cognizant.orderservice.dto.UserDto;
import com.cognizant.orderservice.model.Order;
import com.cognizant.orderservice.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private OrderRepository orderRepository;

    @Value("${custom.message:Hello locally!}")
    private String customMessage;

    @GetMapping("/message")
    public Map<String, String> getMessage() {
        return Map.of("message", customMessage);
    }

    @PostMapping("/user/{userId}")
    public Order placeOrder(@RequestParam String product, @RequestParam Integer quantity, @PathVariable Long userId) {
        Order order = new Order(null, product, quantity, userId, null);
        return orderRepository.save(order);
    }

    @GetMapping("/{id}/user/{userId}")
    @CircuitBreaker(name = "userServiceBreaker", fallbackMethod = "fallbackGetUser")
    public Order getOrder(@PathVariable Long id, @PathVariable Long userId) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        UserDto user = userClient.getUserById(userId);
        order.setUser(user);
        return order;
    }

    public Order fallbackGetUser(Long id, Long userId, Throwable t) {
        Order order = orderRepository.findById(id)
                .orElse(new Order(id, "Fallback Laptop", 1, userId, null));
        UserDto anonymousUser = new UserDto(userId, "Fallback User (Service Offline)", "fallback@example.com");
        order.setUser(anonymousUser);
        return order;
    }
}
