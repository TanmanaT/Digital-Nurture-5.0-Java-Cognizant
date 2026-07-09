# Hands-On 3: REST - Country Web Service

## Objectives
* Expose a REST endpoint that returns a custom object serialized as JSON.

## Steps
1. Create `com.cognizant.springlearn.controller.CountryController` class:
   ```java
   package com.cognizant.springlearn.controller;

   import com.cognizant.springlearn.Country;
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   public class CountryController {
       private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

       @RequestMapping("/country")
       public Country getCountryIndia() {
           LOGGER.info("START getCountryIndia");
           ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
           Country country = context.getBean("in", Country.class);
           LOGGER.info("END getCountryIndia");
           return country;
       }
   }
   ```
2. Verify the JSON response on `http://localhost:8083/country`:
   ```json
   {
     "code": "IN",
     "name": "India"
   }
   ```
