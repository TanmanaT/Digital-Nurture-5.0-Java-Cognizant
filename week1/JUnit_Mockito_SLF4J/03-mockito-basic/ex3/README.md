# Exercise 3: Argument Matching

## Scenario
You need to verify that a method is called with specific arguments, or match any argument of a certain type.

## Steps
1. Define a method `getData(String key)` in `ExternalApi`.
2. Write a test case using `anyString()` to match any string argument passed to `getData`.
3. Verify that the dependency was called with that argument matcher.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/ExternalApi.java`](./src/main/ExternalApi.java): API interface with parameterized method.
- [`src/main/MyService.java`](./src/main/MyService.java): Target service.
- [`src/test/MyServiceTest.java`](./src/test/MyServiceTest.java): JUnit 5 test class demonstrating argument matchers.
