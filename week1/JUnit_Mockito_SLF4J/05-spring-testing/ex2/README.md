# Exercise 2: Mocking a Repository in a Service Test

## Scenario
Test a service that uses a repository to fetch data by mocking the repository layer dependency.

## Steps
1. Create a `User` entity, `UserRepository` interface extending `JpaRepository`, and a `UserService`.
2. Write a unit test `UserServiceTest` that mocks `UserRepository` using Mockito (without bootstrapping the entire Spring database context) to check `getUserById(Long id)`.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Spring Boot Starter Test and JPA dependencies.
- [`src/main/User.java`](./src/main/User.java): Simple User Entity class.
- [`src/main/UserRepository.java`](./src/main/UserRepository.java): JPA Repository interface.
- [`src/main/UserService.java`](./src/main/UserService.java): Service under test.
- [`src/test/UserServiceTest.java`](./src/test/UserServiceTest.java): JUnit 5 test using `@ExtendWith(MockitoExtension.class)` and `@Mock`.
