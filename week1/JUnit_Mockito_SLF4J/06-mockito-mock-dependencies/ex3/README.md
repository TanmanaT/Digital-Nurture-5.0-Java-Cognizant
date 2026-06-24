# Exercise 3: Mocking a Service Dependency in an Integration Test

## Task
Write an integration test for a Spring Boot application that mocks a service dependency using Mockito.

## Steps
1. Create a Spring Boot application bootloader class `Application.java`.
2. Configure a REST endpoint in `UserController` that calls `UserService.getUserById(id)`.
3. Write `UserIntegrationTest` using `@SpringBootTest` and `@AutoConfigureMockMvc`.
4. Use `@MockBean` on `UserService` to mock the service layer inside the boot integration context.
5. Perform a mock request using `MockMvc` and assert controller interactions against the mocked service bean.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Web and Test dependencies.
- [`src/main/Application.java`](./src/main/Application.java): Spring Boot application loader.
- [`src/main/User.java`](./src/main/User.java): Simple User Entity.
- [`src/main/UserService.java`](./src/main/UserService.java): Service class to be mocked.
- [`src/main/UserController.java`](./src/main/UserController.java): REST Controller.
- [`src/test/UserIntegrationTest.java`](./src/test/UserIntegrationTest.java): JUnit 5 integration test using `@MockBean`.
