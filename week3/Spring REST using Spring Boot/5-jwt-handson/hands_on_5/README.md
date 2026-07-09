# Hands-On 5: Generate JWT & Authorize using Filters

## Objectives
* Generate token via JSON Web Token libraries and authorize client requests intercepting them with a filter.

## Steps
1. Add `jjwt` library to `pom.xml`:
   ```xml
   <dependency>
       <groupId>io.jsonwebtoken</groupId>
       <artifactId>jjwt</artifactId>
       <version>0.9.0</version>
   </dependency>
   ```
2. Build JWT using Jwts builder in `AuthenticationController`:
   ```java
   private String generateJwt(String user) {
       JwtBuilder builder = Jwts.builder();
       builder.setSubject(user);
       builder.setIssuedAt(new Date());
       builder.setExpiration(new Date(System.currentTimeMillis() + 1200000)); // 20 min
       builder.signWith(SignatureAlgorithm.HS256, "secretkey");
       return builder.compact();
   }
   ```
3. Create `JwtAuthorizationFilter` extending `BasicAuthenticationFilter`:
   * Parse the token from header: `token.replace("Bearer ", "")`
   * Parse claims using `Jwts.parser().setSigningKey("secretkey").parseClaimsJws(...)`
   * Set security context using `SecurityContextHolder.getContext().setAuthentication(auth)`
4. Secure URLs in `SecurityConfig`:
   ```java
   httpSecurity.csrf().disable().httpBasic().and()
       .authorizeRequests()
       .antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
       .anyRequest().authenticated()
       .and()
       .addFilter(new JwtAuthorizationFilter(authenticationManager()));
   ```
5. Test fetching `/countries` by setting Header: `Authorization: Bearer <JWT_TOKEN>`.
