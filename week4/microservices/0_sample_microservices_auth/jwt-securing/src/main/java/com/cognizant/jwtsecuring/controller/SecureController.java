package com.cognizant.jwtsecuring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public Map<String, Object> secure() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Map.of(
            "message", "This is a secure endpoint",
            "user", auth.getName(),
            "authorities", auth.getAuthorities()
        );
    }
}
