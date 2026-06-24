# Exercise 4: Mocking Network Interactions

## Scenario
You need to test a service that interacts with network resources.

## Steps
1. Create a mock network client `NetworkClient` using Mockito.
2. Stub the network client methods (e.g. `connect()`) to simulate network connections and response interactions.
3. Write a test to verify the service logic (`connectToServer()`) using the mocked network client.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/NetworkClient.java`](./src/main/NetworkClient.java): Network Client interface.
- [`src/main/NetworkService.java`](./src/main/NetworkService.java): Network Service class.
- [`src/test/NetworkServiceTest.java`](./src/test/NetworkServiceTest.java): JUnit 5 test class demonstrating network mocking.
