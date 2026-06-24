# Exercise 1: Mocking Databases and Repositories

## Scenario
You need to test a service that interacts with a database repository.

## Steps
1. Create a mock repository `Repository` using Mockito.
2. Stub repository methods (e.g. `getData()`) to return predefined data.
3. Write a test in `ServiceTest` to verify the service logic (`processData()`) using the mocked repository.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/Repository.java`](./src/main/Repository.java): Repository layer interface.
- [`src/main/Service.java`](./src/main/Service.java): Service layer class.
- [`src/test/ServiceTest.java`](./src/test/ServiceTest.java): JUnit 5 test class demonstrating database mocking.
