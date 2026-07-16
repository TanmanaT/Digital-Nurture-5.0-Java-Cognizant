# Topic 1: Centralized Authentication & SSO

This section covers implementation examples of Centralized Authentication and Single Sign-On (SSO) with Spring Boot 3.x and Spring Cloud.

## 📂 Projects

### 1. `oauth2-client-sso`
- **Goal**: Implement centralized authentication using OAuth 2.1 / OIDC.
- **Dependencies**: `spring-boot-starter-security`, `spring-boot-starter-oauth2-client`, `spring-boot-starter-web`.
- **Key Files**:
  - `SecurityConfig.java`: Enables web security and oauth2Login.
  - `UserController.java`: Returns authenticated user principal info.

### 2. `oauth2-resource-server`
- **Goal**: Protect API endpoints by verifying JWTs issued by an identity provider.
- **Dependencies**: `spring-boot-starter-security`, `spring-boot-starter-oauth2-resource-server`, `spring-boot-starter-web`.
- **Key Files**:
  - `ResourceServerConfig.java`: Configures oauth2ResourceServer authentication.
  - `SecureController.java`: A protected endpoint (`/secure`) requiring JWT credentials.

### 3. `jwt-securing`
- **Goal**: Custom JWT generation, verification, and filter propagation.
- **Dependencies**: `spring-boot-starter-security`, `jjwt` (JSON Web Token), `spring-boot-starter-web`.
- **Key Files**:
  - `JwtTokenProvider.java`: Generates, parses, and validates JWT tokens.
  - `JwtTokenFilter.java`: Custom request filter checking Authorization headers.
  - `SecurityConfig.java`: Adds the custom filter in front of UsernamePasswordAuthenticationFilter.
