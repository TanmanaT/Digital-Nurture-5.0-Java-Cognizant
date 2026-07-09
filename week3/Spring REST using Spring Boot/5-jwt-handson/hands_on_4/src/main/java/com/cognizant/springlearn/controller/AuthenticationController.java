package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START authenticate");
        String user = getUser(authHeader);
        LOGGER.info("Authenticated User: {}", user);
        Map<String, String> map = new HashMap<>();
        map.put("token", "");
        LOGGER.info("END authenticate");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring(6);
        byte[] decoded = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decoded);
        return credentials.split(":")[0]; // return username
    }
}
