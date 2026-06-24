# Exercise 2: Verifying Interactions

## Scenario
You need to ensure that a method is called with specific arguments.

## Steps
1. Create a mock object for `ExternalApi`.
2. Call `fetchData()` on `MyService`, which should trigger the API call.
3. Verify that `getData()` on the mock API was indeed executed using Mockito's `verify()`.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/ExternalApi.java`](./src/main/ExternalApi.java): External API dependency interface.
- [`src/main/MyService.java`](./src/main/MyService.java): Target service class.
- [`src/test/MyServiceTest.java`](./src/test/MyServiceTest.java): JUnit 5 test class demonstrating interaction verification.
