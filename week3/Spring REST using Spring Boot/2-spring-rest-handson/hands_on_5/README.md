# Hands-On 5: REST - Get Country Based on Country Code

## Objectives
* Implement a path parameter mapping using `@PathVariable`.

## Steps
1. Create `com.cognizant.springlearn.service.CountryService` class:
   ```java
   package com.cognizant.springlearn.service;

   import com.cognizant.springlearn.Country;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   import org.springframework.stereotype.Service;
   import java.util.List;

   @Service
   public class CountryService {
       public Country getCountry(String code) {
           ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
           List<Country> list = context.getBean("countryList", List.class);
           return list.stream()
               .filter(c -> c.getCode().equalsIgnoreCase(code))
               .findFirst()
               .orElse(null);
       }
   }
   ```
2. Update `CountryController` to call the service:
   ```java
   @Autowired
   private CountryService countryService;

   @GetMapping("/countries/{code}")
   public Country getCountry(@PathVariable String code) {
       return countryService.getCountry(code);
   }
   ```
3. Test using `http://localhost:8083/countries/in`.
