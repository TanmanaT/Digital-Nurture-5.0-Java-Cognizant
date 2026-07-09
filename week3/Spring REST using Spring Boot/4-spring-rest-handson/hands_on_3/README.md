# Hands-On 3: Read Country Data as a Bean

## Objectives
* Map JSON payload properties to Java objects using `@RequestBody` and Jackson parser.

## Steps
1. Update `addCountry()` signature:
   ```java
   @PostMapping
   public Country addCountry(@RequestBody Country country) {
       LOGGER.info("START addCountry: {}", country);
       return country;
   }
   ```
2. Test:
   ```bash
   curl -i -H 'Content-Type: application/json' -X POST -s -d '{"code":"IN","name":"India"}' http://localhost:8090/countries
   ```
