# Exercise 7: Test Custom Repository Query

## Scenario
Add and test a custom repository query method.

## Repository Interface
```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
```

## Steps
1. Add `findByName` to the JPA repository interface.
2. Create a test class `UserRepositoryQueryTest` with `@DataJpaTest`.
3. In the test, save users using the test entity manager or repository.
4. Call `findByName` and assert that it returns the expected collection of records.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Starter Data JPA and Test.
- [`src/main/Application.java`](./src/main/Application.java): Spring Boot application loader.
- [`src/main/User.java`](./src/main/User.java): Simple User Entity.
- [`src/main/UserRepository.java`](./src/main/UserRepository.java): JPA Repository.
- [`src/test/UserRepositoryQueryTest.java`](./src/test/UserRepositoryQueryTest.java): JUnit 5 test class demonstrating `@DataJpaTest`.
