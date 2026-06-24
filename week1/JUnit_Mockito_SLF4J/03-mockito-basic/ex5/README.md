# Exercise 5: Mocking and Stubbing with Multiple Returns

## Scenario
You need to test a service that depends on an external API with multiple return values on consecutive calls.

## Steps
1. Create a mock object for `ExternalApi`.
2. Stub `getData()` to return different values on consecutive calls using method chaining or multiple arguments.
3. Write a test case in `MyServiceTest` to call it twice and assert the sequence of responses.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/ExternalApi.java`](./src/main/ExternalApi.java): API dependency.
- [`src/main/MyService.java`](./src/main/MyService.java): Target service.
- [`src/test/MyServiceTest.java`](./src/test/MyServiceTest.java): JUnit 5 test class for stubbing multiple returns.
