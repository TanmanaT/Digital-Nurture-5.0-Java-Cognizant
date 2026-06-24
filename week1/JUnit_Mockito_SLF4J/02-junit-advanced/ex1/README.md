# Exercise 1: Parameterized Tests

## Scenario
You want to test a method that checks if a number is even. Instead of writing multiple test cases, you will use parameterized tests to run the same test with different inputs.

## Steps
1. Create a Java class `EvenChecker` with a method `isEven(int number)`.
2. Write a parameterized test class `EvenCheckerTest` that tests the `isEven` method with different inputs.
3. Use JUnit 5's `@ParameterizedTest` and `@ValueSource` annotations.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter dependencies.
- [`src/main/EvenChecker.java`](./src/main/EvenChecker.java): Utility class to check even numbers.
- [`src/test/EvenCheckerTest.java`](./src/test/EvenCheckerTest.java): JUnit 5 test class using `@ParameterizedTest` and `@ValueSource`.
