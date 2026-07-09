# Hands-On 6: REST - Get Country Exceptional Scenario

## Objectives
* Define a custom HTTP status mapping using `@ResponseStatus`.

## Steps
1. Create custom exception class `com.cognizant.springlearn.service.exception.CountryNotFoundException`:
   ```java
   package com.cognizant.springlearn.service.exception;

   import org.springframework.http.HttpStatus;
   import org.springframework.web.bind.annotation.ResponseStatus;

   @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
   public class CountryNotFoundException extends Exception {
   }
   ```
2. Update `CountryService.getCountry()` to throw this exception if the country is not found:
   ```java
   public Country getCountry(String code) throws CountryNotFoundException {
       ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
       List<Country> list = context.getBean("countryList", List.class);
       return list.stream()
           .filter(c -> c.getCode().equalsIgnoreCase(code))
           .findFirst()
           .orElseThrow(CountryNotFoundException::new);
   }
   ```
3. Update `CountryController` method signature to throw `CountryNotFoundException`.
4. Test with a non-existent code:
   ```bash
   curl -i http://localhost:8090/country/az
   ```
   Verify you receive a `404 Not Found` response with a JSON body.
