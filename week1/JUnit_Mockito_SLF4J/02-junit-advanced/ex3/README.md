# Exercise 3: Test Execution Order

## Scenario
You want to control the order in which tests are executed.

## Steps
1. Create a test class `OrderedTests`.
2. Use JUnit 5's `@TestMethodOrder` and `@Order` annotations to set a specific execution sequence for three test methods.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter dependencies.
- [`src/test/OrderedTests.java`](./src/test/OrderedTests.java): Test class enforcing a specific execution order on tests.
