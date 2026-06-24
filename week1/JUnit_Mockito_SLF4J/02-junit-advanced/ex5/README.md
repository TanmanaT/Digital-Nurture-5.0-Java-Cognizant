# Exercise 5: Timeout and Performance Testing

## Scenario
You want to ensure that a method completes within a specified time limit.

## Steps
1. Create a class `PerformanceTester` with a method `performTask`.
2. Write a test class `PerformanceTesterTest` that tests the method for timeout using JUnit 5's `assertTimeout` or `@Timeout` annotation.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter.
- [`src/main/PerformanceTester.java`](./src/main/PerformanceTester.java): Target class performing tasks with potential delays.
- [`src/test/PerformanceTesterTest.java`](./src/test/PerformanceTesterTest.java): JUnit 5 test class checking execution time.
