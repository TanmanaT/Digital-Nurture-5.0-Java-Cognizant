package com.cognizant.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayRateLimiterConfig {

    @Bean
    public KeyResolver userKeyResolver() {
        // Resolve key by Request Header "X-User" or fallback to host address
        return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("X-User"))
                .defaultIfEmpty(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
