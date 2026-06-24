# Exercise 5: Test Controller POST Endpoint

## Scenario
Test a POST endpoint that creates a user.

## Controller Endpoint
```java
@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.saveUser(user));
}
```

## Steps
1. Create user entity, service, and controller matching the above endpoint.
2. Write a test class `UserControllerPostTest` that mocks `UserService`.
3. Use MockMvc to send a POST request with a serialized JSON payload to create a new user and verify that it returns status code `200 OK` along with the created user's data.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Web and Test dependencies.
- [`src/main/User.java`](./src/main/User.java): Simple User Entity.
- [`src/main/UserService.java`](./src/main/UserService.java): Service dependency.
- [`src/main/UserController.java`](./src/main/UserController.java): REST Controller.
- [`src/test/UserControllerPostTest.java`](./src/test/UserControllerPostTest.java): JUnit 5 MockMvc test for POST request.
