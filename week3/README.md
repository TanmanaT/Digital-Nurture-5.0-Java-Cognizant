# Week 3 - Spring Boot REST and Security

This directory contains the hands-on exercises, source code, and configurations implemented during Week 3.

## 📂 Contents

1. **[Spring REST using Spring Boot](./Spring%20REST%20using%20Spring%20Boot)**
   - Hands-on exercises and configurations covering Spring Boot RESTful Web Services, HTTP Request/Response structure, GET/POST/PUT/DELETE API endpoints, `@RestController`, `@PathVariable`, `@RequestBody`, validations using `javax.validation`, global exception handling using `@ControllerAdvice`, and JWT (JSON Web Token) authentication with Spring Security.

---

## 🚀 How to Run the Applications

Each hands-on folder contains a standalone Maven project. You can run any project using the following instructions:

### Prerequisites
* **Java Development Kit (JDK)**: Version 17 or 20 (already verified on system)
* **Apache Maven**: (Ensure Maven is configured in your IDE, e.g., Eclipse or VS Code, or install it on your system PATH)

### Running via Command Line
1. Navigate to the specific hands-on directory (for example, the final stage in a series):
   ```bash
   cd "week3/Spring REST using Spring Boot/5-jwt-handson/hands_on_5"
   ```
2. Build and package the application:
   ```bash
   mvn clean package
   ```
3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
   *Alternatively, run the generated JAR:*
   ```bash
   java -jar target/spring-learn-0.0.1-SNAPSHOT.jar
   ```

---

## 🧪 Running Automated Tests

To run the JUnit integration tests (including `MockMvc` test suites):
1. Navigate to the project directory:
   ```bash
   cd "week3/Spring REST using Spring Boot/2-spring-rest-handson/hands_on_8"
   ```
2. Run the test command:
   ```bash
   mvn clean test
   ```

---

## 🔑 In-Memory Authentication & JWT Testing

For the security and JWT exercises (located in `5-jwt-handson/hands_on_5`):

### 1. Hardcoded Credentials
* **Admin User**: `admin` / `pwd` (Role: `ADMIN`)
* **Standard User**: `user` / `pwd` (Role: `USER`)

### 2. Authentication Flow (JWT)
1. **Request a Token**:
   Send a `POST` request to `/authenticate` with Basic Auth credentials:
   ```bash
   curl -u user:pwd -X POST http://localhost:8083/authenticate
   ```
   *Response:* Returns a JSON Web Token (JWT) string.
   
2. **Access Protected Endpoints**:
   Pass the JWT inside the `Authorization` header as a Bearer token:
   ```bash
   curl -H "Authorization: Bearer <YOUR_TOKEN>" http://localhost:8083/countries
   ```

