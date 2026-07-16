package com.cognizant.jwtsecuring.controller;

import com.cognizant.jwtsecuring.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/token")
    public Map<String, String> token(@RequestParam String username) {
        String token = jwtTokenProvider.createToken(username);
        return Map.of("token", token);
    }
}
