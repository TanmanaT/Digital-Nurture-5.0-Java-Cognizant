# Exercise 7: Handling Void Methods with Exceptions

## Scenario
You need to test that a void method throws an exception when invoked with certain inputs or conditions.

## Steps
1. Define a void method `doSomethingDangerous()` in `ExternalApi`.
2. Implement a method `executeTask()` in `MyService` that calls `doSomethingDangerous()`.
3. Write a test case using `doThrow(...)` to stub the void method so that it throws a `RuntimeException`.
4. Assert that the service propagates the exception.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/ExternalApi.java`](./src/main/ExternalApi.java): API dependency interface.
- [`src/main/MyService.java`](./src/main/MyService.java): Target service.
- [`src/test/MyServiceTest.java`](./src/test/MyServiceTest.java): JUnit 5 test class demonstrating void method stubbed to throw exceptions.
