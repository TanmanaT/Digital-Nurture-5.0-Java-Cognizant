# Exercise 8: Test Controller Exception Handling

## Scenario
Add and test a `@ControllerAdvice` for handling exceptions.

## Exception Handler
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
```

## Steps
1. Implement a `GlobalExceptionHandler` with the `@ControllerAdvice` annotation and `@ExceptionHandler`.
2. Write a test case `UserControllerAdviceTest` using MockMvc.
3. Stub the service to throw a `NoSuchElementException` and perform a GET request.
4. Verify that the response status code is `404 Not Found` and the response body is `"User not found"`.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Web and Test dependencies.
- [`src/main/User.java`](./src/main/User.java): Simple User Entity.
- [`src/main/UserService.java`](./src/main/UserService.java): Service dependency.
- [`src/main/UserController.java`](./src/main/UserController.java): REST Controller.
- [`src/main/GlobalExceptionHandler.java`](./src/main/GlobalExceptionHandler.java): Exception handler aspect class.
- [`src/test/UserControllerAdviceTest.java`](./src/test/UserControllerAdviceTest.java): MockMvc JUnit 5 test class checking exception handling.
