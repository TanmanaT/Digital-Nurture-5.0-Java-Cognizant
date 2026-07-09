# Hands-On 1: Securing Web Services with Spring Security

## Objectives
* Secure endpoints by integrating `spring-boot-starter-security` basic authentication rules.

## Steps
1. Add Spring Security dependency to `pom.xml`:
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-security</artifactId>
   </dependency>
   ```
2. Create `com.cognizant.springlearn.security.SecurityConfig` extending `WebSecurityConfigurerAdapter`:
   * Annotate class with `@Configuration` and `@EnableWebSecurity`.
3. Try accessing `http://localhost:8090/countries` without credentials; verify you get a `401 Unauthorized` response.
4. Access it using the default generated password printed in your console log:
   ```bash
   curl -s -v -u user:GENERATED_PASSWORD http://localhost:8090/countries
   ```
