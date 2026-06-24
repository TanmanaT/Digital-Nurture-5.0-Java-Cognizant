# Exercise 6: Test Service Exception Handling

## Scenario
Test how a service handles a missing user (verifying that it throws `NoSuchElementException` when a user ID does not exist).

## Steps
1. In `UserService`, implement `getUserById(Long id)` to throw `NoSuchElementException` when the repository returns empty.
2. Write a unit test `UserServiceExceptionTest` that stubs the repository to return empty and asserts that the service correctly propagates the `NoSuchElementException`.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JPA and Spring Boot Starter Test.
- [`src/main/User.java`](./src/main/User.java): Simple User Entity.
- [`src/main/UserRepository.java`](./src/main/UserRepository.java): JPA Repository.
- [`src/main/UserService.java`](./src/main/UserService.java): Service containing logic that throws exception.
- [`src/test/UserServiceExceptionTest.java`](./src/test/UserServiceExceptionTest.java): JUnit 5 test class asserting exception throw.
