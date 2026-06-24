# Exercise 2: Mocking a Repository in a Service Test

## Task
Write a unit test for a Spring service that uses a repository to fetch data. Mock the repository dependency using Mockito.

## Steps
1. Create the `User` entity, `UserRepository` interface extending `JpaRepository`, and a `UserService`.
2. Write a JUnit 5 unit test `UserServiceTest` utilizing `@ExtendWith(MockitoExtension.class)`.
3. Use `@Mock` for `UserRepository` and `@InjectMocks` for `UserService`.
4. Stub `findById()` and verify it gets called during service-layer processing.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JPA and Test dependencies.
- [`src/main/User.java`](./src/main/User.java): Entity class.
- [`src/main/UserRepository.java`](./src/main/UserRepository.java): Repository interface.
- [`src/main/UserService.java`](./src/main/UserService.java): Service class.
- [`src/test/UserServiceTest.java`](./src/test/UserServiceTest.java): JUnit 5 test class demonstrating repository mocking.
