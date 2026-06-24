# Exercise 2: Mocking External Services (RESTful APIs)

## Scenario
You need to test a service that calls an external RESTful API.

## Steps
1. Create a mock REST client `RestClient` using Mockito.
2. Stub the REST client methods (e.g. `getResponse()`) to return predefined responses.
3. Write a test to verify the service logic (`fetchData()`) using the mocked REST client.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/RestClient.java`](./src/main/RestClient.java): REST Client interface.
- [`src/main/ApiService.java`](./src/main/ApiService.java): API service consuming the client.
- [`src/test/ApiServiceTest.java`](./src/test/ApiServiceTest.java): JUnit 5 test class demonstrating REST mocking.
