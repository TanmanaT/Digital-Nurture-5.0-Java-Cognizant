# Exercise 1: Mocking and Stubbing

## Scenario
You need to test a service that depends on an external API. Use Mockito to mock the external API and stub its methods.

## Steps
1. Create a mock object for `ExternalApi`.
2. Stub `getData()` to return a predefined string.
3. Verify that `MyService` uses the mocked value.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core dependencies.
- [`src/main/ExternalApi.java`](./src/main/ExternalApi.java): External API dependency interface.
- [`src/main/MyService.java`](./src/main/MyService.java): Target service class depending on the API.
- [`src/test/MyServiceTest.java`](./src/test/MyServiceTest.java): JUnit 5 test class demonstrating mocking and stubbing.
