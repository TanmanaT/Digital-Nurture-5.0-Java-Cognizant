# Exercise 5: Mocking Multiple Return Values

## Scenario
You need to test a service that calls a method multiple times with different return values.

## Steps
1. Create a mock object for `Repository` using Mockito.
2. Stub `getData()` to return different values on consecutive calls.
3. Write a test to verify the service logic (`processData()`) called multiple times using the mocked repository.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/Repository.java`](./src/main/Repository.java): Repository layer interface.
- [`src/main/Service.java`](./src/main/Service.java): Service layer class.
- [`src/test/MultiReturnServiceTest.java`](./src/test/MultiReturnServiceTest.java): JUnit 5 test class demonstrating multiple returns in Mockito.
