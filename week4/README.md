# Week 4 - Microservices with Spring Boot 3 & Spring Cloud

This directory contains the hands-on exercises, configuration setups, and code modules built during Week 4 focusing on Microservice Architectures, Service Discovery, Edge Gateways, Load Balancing, Centralized Configuration, Circuit Breakers, and OAuth2/JWT security.

## 📂 Contents

1. **[Centralized Authentication & SSO](./microservices/0_sample_microservices_auth)**
   - OAuth 2.1/OIDC Single Sign-On (SSO) Client, resource server protection, and custom JSON Web Tokens (JWT) handling with Spring Security.

2. **[Load Balancing & Gateway Edge Services](./microservices/0_sample_microservices_load_balancing)**
   - Spring Cloud Gateway configuration routing requests, integrating Spring Cloud LoadBalancer (`lb://` schemes), and implementing resilience patterns.

3. **[Spring Boot 3 Core Microservices Pattern](./microservices/1_springboot3_microservices)**
   - Core hands-on: User Service and Order Service communicating via OpenFeign/WebClient, Product & Inventory Service integrated with Eureka Discovery, Config Server, and Resilience4j circuit breakers.

4. **[API Gateway Composite Hands-On](./microservices/2_microservices_api_gateway_composite)**
   - Greet Service, Eureka discovery server registration, and Spring Cloud Gateway with custom logging filter and lowercase service name routing.
