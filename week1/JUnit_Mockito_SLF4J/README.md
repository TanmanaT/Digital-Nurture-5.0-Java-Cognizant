# JUnit, Mockito, and SL4J Hands-On Exercises

This directory contains modular hands-on exercises covering unit testing, mock testing, and logging in Java.

## 📂 Directory Layout

1. **[01-junit-basic](./01-junit-basic)**: Core testing concepts, basic test writing, assertions, and test fixtures (AAA pattern).
2. **[02-junit-advanced](./02-junit-advanced)**: Parameterized testing, test suites, ordering, exceptions, and performance/timeout testing.
3. **[03-mockito-basic](./03-mockito-basic)**: Basic mocking, stubbing, argument matching, void methods, and verification techniques.
4. **[04-mockito-advanced](./04-mockito-advanced)**: Mocking databases, REST APIs, File I/O, network interactions, and consecutive stubbing.
5. **[05-spring-testing](./05-spring-testing)**: Testing in Spring Boot environment, MockMvc, integration tests, exception handlers, and custom repositories.
6. **[06-mockito-mock-dependencies](./06-mockito-mock-dependencies)**: Mocking service and repository dependencies specifically in Spring contexts.
7. **[07-sl4j-logging](./07-sl4j-logging)**: Basic logging with SL4J, parameterized messages, and different appender configurations.

---

## 🛠️ Requirements & Executing Tests

To run these tests, you can import any subfolder as a Maven project into your IDE (e.g., IntelliJ IDEA, Eclipse, VS Code).
Alternatively, if you have Maven installed locally:
```bash
mvn test
```
inside any of the exercise folders containing a `pom.xml`.
