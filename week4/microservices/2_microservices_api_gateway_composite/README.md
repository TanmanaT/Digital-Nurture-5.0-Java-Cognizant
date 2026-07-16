# Topic 4: API Gateway Composite Hands-On

This folder contains the composite hands-on lab integrating a service registry, a microservice, and an API Gateway with routing and custom request logging:
- Service Discovery Registry (Eureka Server)
- Microservice containing a REST endpoint (Greet Service)
- API Gateway routing requests dynamically with lowercase naming and a global request filter (API Gateway)

## 📂 Sub-Projects

1. **`eureka-discovery-server`**: Eureka Service Registry running on port `8761`.
2. **`greet-service`**: Microservice hosting a simple REST endpoint (`/greet`) returning `"Hello World!!"`, running on port `8080` (registers to Eureka).
3. **`api-gateway`**: Gateway edge service running on port `9090`. Uses discovery locator to route `/greet-service/**` to the registry name using lowercase format, and executes a global `LogFilter` logging all incoming URL paths.
