# Exercise 6: Verifying Interaction Order

## Scenario
You need to ensure that methods on mock objects are called in a specific order.

## Steps
1. Define methods `firstAction()` and `secondAction()` in `ExternalApi`.
2. Implement a method `runActions()` in `MyService` that executes them in sequence.
3. Write a test case using Mockito's `inOrder()` to verify that `firstAction()` is called before `secondAction()`.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/ExternalApi.java`](./src/main/ExternalApi.java): API dependency.
- [`src/main/MyService.java`](./src/main/MyService.java): Target service.
- [`src/test/MyServiceTest.java`](./src/test/MyServiceTest.java): JUnit 5 test class demonstrating order verification.
