# Exercise 4: Integration Test with Spring Boot

## Scenario
Write an integration test that tests the full flow from controller to database.

## Steps
1. Create a Spring Boot application bootloader class `Application.java`.
2. Configure a test H2 database context.
3. Write `UserIntegrationTest` using `@SpringBootTest` and `@AutoConfigureMockMvc`.
4. Perform an integration request to `/users/{id}` and assert that it correctly loads and retrieves data from the H2 database.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Web, JPA, Test, and H2 database dependencies.
- [`src/main/Application.java`](./src/main/Application.java): Spring Boot application class.
- [`src/main/User.java`](./src/main/User.java): JPA User Entity.
- [`src/main/UserRepository.java`](./src/main/UserRepository.java): JPA Repository.
- [`src/main/UserService.java`](./src/main/UserService.java): Service component.
- [`src/main/UserController.java`](./src/main/UserController.java): REST Controller.
- [`src/test/UserIntegrationTest.java`](./src/test/UserIntegrationTest.java): JUnit 5 integration test.
