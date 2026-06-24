# Exercise 3: Testing a REST Controller with MockMvc

## Scenario
Test a controller endpoint that returns a user.

## Controller Class
```java
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
```

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with Spring Boot Starter Web and Test dependencies.
- [`src/main/User.java`](./src/main/User.java): Simple User Entity class.
- [`src/main/UserService.java`](./src/main/UserService.java): Service class dependency.
- [`src/main/UserController.java`](./src/main/UserController.java): REST Controller class.
- [`src/test/UserControllerTest.java`](./src/test/UserControllerTest.java): JUnit 5 test class demonstrating MockMvc testing with `@WebMvcTest`.
