# Topic 2: Load Balancing & Gateway Edge Services

This section implements routing, filtering, load balancing, and circuit breaker patterns in an API Gateway utilizing Spring Cloud Gateway and Resilience4j.

## 📂 Projects

### 1. `api-gateway`
- **Goal**: Implement an API Gateway routing requests with custom filters, load balancing (`lb://` schemes), and resilience rules.
- **Dependencies**: `spring-cloud-starter-gateway`, `spring-cloud-starter-loadbalancer`, `resilience4j-spring-boot2` (or `spring-cloud-starter-circuitbreaker-reactor-resilience4j`).
- **Key Files**:
  - `application.properties`: Configuration mapping gateway routes, predicates, load balancers, and Resilience4j limits.
  - `LoggingFilter.java`: Custom `GlobalFilter` logging HTTP request details.
  - `ResilienceConfiguration.java`: Defines default fallback circuit breaker limits.
