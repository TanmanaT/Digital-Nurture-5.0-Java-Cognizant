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
   - Greet Service, Account Service, Loan Service, Eureka discovery server registration, and Spring Cloud Gateway with custom logging filter and lowercase service name routing.

## 🚀 How to Run

### Prerequisites
- **Java**: Version 17
- **Maven**: Version 3.x

### Build All Services
To build all projects, navigate to the target microservice folder (e.g., `./microservices/2_microservices_api_gateway_composite/account-service`) and run:
```bash
mvn clean package
```

### Steps to Run

#### 1. Running the API Gateway & Composite Hands-On (`2_microservices_api_gateway_composite`)
1. **Start Eureka Discovery Server**:
   - Navigate to `/microservices/2_microservices_api_gateway_composite/eureka-discovery-server`
   - Run: `mvn spring-boot:run` (Runs on port `8761`)
2. **Start Client Microservices**:
   - Navigate to and run `mvn spring-boot:run` in:
     - `account-service` (Runs on port `8080`)
     - `loan-service` (Runs on port `8081`)
     - `greet-service` (Runs on port `8082`)
3. **Start API Gateway**:
   - Navigate to `/microservices/2_microservices_api_gateway_composite/api-gateway`
   - Run: `mvn spring-boot:run` (Runs on port `9090`)
4. **Verify Routes**:
   - Access the services through the API Gateway:
     - **Accounts**: `http://localhost:9090/account-service/accounts/00987987973432`
     - **Loans**: `http://localhost:9090/loan-service/loans/H00987987972342`
     - **Greet**: `http://localhost:9090/greet-service/greet`

#### 2. Running Core Patterns (`1_springboot3_microservices`)
1. **Start Eureka Server**:
   - Navigate to `/microservices/1_springboot3_microservices/eureka-server` and run `mvn spring-boot:run` (Runs on port `8761`).
2. **Start Config Server**:
   - Navigate to `/microservices/1_springboot3_microservices/config-server` and run `mvn spring-boot:run` (Runs on port `8888`).
3. **Start Core Services**:
   - Start the individual modules (`user-service`, `order-service`, `product-service`, `inventory-service`, `customer-service`, `billing-service`, `payment-service`) with `mvn spring-boot:run`.

