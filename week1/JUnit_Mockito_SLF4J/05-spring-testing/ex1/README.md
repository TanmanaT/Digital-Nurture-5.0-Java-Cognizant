# Exercise 1: Basic Unit Test for a Service Method

## Scenario
Write a unit test for a service method that adds two numbers.

## Service Class
```java
@Service
public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }
}
```

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Spring Boot Starter Test dependencies.
- [`src/main/CalculatorService.java`](./src/main/CalculatorService.java): The `@Service` implementation under test.
- [`src/test/CalculatorServiceTest.java`](./src/test/CalculatorServiceTest.java): JUnit 5 test class checking the addition.
