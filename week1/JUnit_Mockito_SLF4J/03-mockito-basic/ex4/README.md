# Exercise 4: Handling Void Methods

## Scenario
You need to test a void method that performs some action (like logging or updating external state) without throwing exceptions, or stub it to behave in a specific way.

## Steps
1. Define a void method `logAccess(String user)` in `ExternalApi`.
2. Implement a method `logUserActivity(String user)` in `MyService` that invokes the void API method.
3. Write a test case in `MyServiceTest` using `doNothing()` to stub the void method call.
4. Verify that the void method was called.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/ExternalApi.java`](./src/main/ExternalApi.java): API interface with the void method.
- [`src/main/MyService.java`](./src/main/MyService.java): Target service.
- [`src/test/MyServiceTest.java`](./src/test/MyServiceTest.java): JUnit 5 test class demonstrating void method stubbing.
