# Exercise 4: Exception Testing

## Scenario
You want to test that a method throws the expected exception.

## Steps
1. Create a class `ExceptionThrower` with a method `throwException`.
2. Write a test class `ExceptionThrowerTest` that tests the method for the expected exception using JUnit 5's `assertThrows`.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor containing the JUnit Jupiter dependencies.
- [`src/main/ExceptionThrower.java`](./src/main/ExceptionThrower.java): Target class that throws exceptions.
- [`src/test/ExceptionThrowerTest.java`](./src/test/ExceptionThrowerTest.java): JUnit 5 test class checking for exceptions.
