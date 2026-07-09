# Hands-On 2: Hello World RESTful Web Service

## Objectives
* Implement a basic GET endpoint returning a string using `@RestController` and `@GetMapping`

## Steps
1. Create `com.cognizant.springlearn.controller.HelloController` class:
   ```java
   package com.cognizant.springlearn.controller;

   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   public class HelloController {
       private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

       @GetMapping("/hello")
       public String sayHello() {
           LOGGER.info("START sayHello");
           LOGGER.info("END sayHello");
           return "Hello World!!";
       }
   }
   ```
2. Test the URL `http://localhost:8083/hello` in your browser and Postman.
