# Hands-On 2: Handle POST Request for Country

## Objectives
* Implement `@PostMapping` mapping in `CountryController`.

## Steps
1. Add `addCountry()` in `CountryController` mapped to `@PostMapping`:
   ```java
   @PostMapping
   public void addCountry() {
       LOGGER.info("START addCountry");
   }
   ```
2. Invoke using curl/Postman:
   ```bash
   curl -i -X POST -s http://localhost:8090/countries
   ```
