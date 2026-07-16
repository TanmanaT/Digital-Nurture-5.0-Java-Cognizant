# Topic 3: Spring Boot 3 Core Microservices Pattern

This folder implements the core microservice patterns with Spring Boot 3.0 and Spring Cloud:
- Centralized Service Discovery (Eureka Server)
- Centralized Configuration Management (Spring Cloud Config Server)
- Synchronous communication between services via OpenFeign
- Client side resilience using Resilience4j circuit breakers.

## 📂 Sub-Projects

1. **`eureka-server`**: Eureka Service Registry running on port `8761`.
2. **`config-server`**: Config Server running on port `8888` supplying profiles configuration.
3. **`user-service`**: Microservice hosting user endpoints (`/users`), running on port `8085`.
4. **`order-service`**: Orders microservice running on port `8086`. Communicates with `user-service` via OpenFeign. Uses Resilience4j Circuit Breaker for fallback methods when `user-service` is down.
5. **`product-service`**: Product management microservice running on port `8087`, registered with Eureka.
6. **`inventory-service`**: Inventory tracking microservice running on port `8088`, registered with Eureka.
