# Exercise 9: Parameterized Test with JUnit

## Scenario
Use `@ParameterizedTest` to test multiple inputs.

## Steps
1. Create a `CalculatorService` class with an `add(int a, int b)` method.
2. Write a parameterized test class `CalculatorParameterizedTest` using JUnit 5's `@ParameterizedTest` and `@CsvSource`.
3. Test multiple integer pairs and verify their addition results in a single test block.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter API and Params dependencies.
- [`src/main/CalculatorService.java`](./src/main/CalculatorService.java): The Service class being tested.
- [`src/test/CalculatorParameterizedTest.java`](./src/test/CalculatorParameterizedTest.java): JUnit 5 test class demonstrating parameterized inputs.
