# Exercise 1: Mocking a Service Dependency in a Controller Test

## Task
Write a unit test for a Spring controller that uses a service to fetch data. Mock the service dependency using Mockito.

## Steps
1. Create the `User` entity, `UserService`, and `UserController` with appropriate REST endpoints.
2. Write a JUnit 5 test `UserControllerTest` utilizing `@WebMvcTest` and `@MockBean` to mock the service dependency.
3. Stub the service to return a dummy user and verify the REST API response using MockMvc assertions.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Web and Test dependencies.
- [`src/main/User.java`](./src/main/User.java): Entity class.
- [`src/main/UserService.java`](./src/main/UserService.java): Service class.
- [`src/main/UserController.java`](./src/main/UserController.java): REST Controller class.
- [`src/test/UserControllerTest.java`](./src/test/UserControllerTest.java): JUnit 5 controller test class utilizing `@WebMvcTest` and `@MockBean`.
