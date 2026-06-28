# Spring Core and Maven Exercises

This directory contains exercises focusing on the Spring Framework (IoC, DI, AOP) and Maven.

## Exercises

1. **[Exercise 1: Configuring a Basic Spring Application](./ex1)**: Set up a basic Spring project with XML configuration and define beans.
2. **[Exercise 2: Implementing Dependency Injection](./ex2)**: Manage class dependencies using setter-based dependency injection.
3. **[Exercise 3: Implementing Logging with Spring AOP](./ex3)**: Integrate Spring AOP for tracking method execution times.
4. **[Exercise 4: Creating and Configuring a Maven Project](./ex4)**: Build a custom Maven project structure with specific compiler versions and multiple dependencies.
5. **[Exercise 5: Configuring the Spring IoC Container](./ex5)**: Explore central configuration of beans and dependency management with Spring IoC.
6. **[Exercise 6: Configuring Beans with Annotations](./ex6)**: Simplify configuration using component scanning and stereotype annotations (`@Service`, `@Repository`).
7. **[Exercise 7: Implementing Constructor and Setter Injection](./ex7)**: Compare and implement constructor-based and setter-based dependency injection.
8. **[Exercise 8: Implementing Basic AOP with Spring](./ex8)**: Configure AOP AspectJ auto-proxying and define custom advice methods (Before, After).
9. **[Exercise 9: Creating a Spring Boot Application](./ex9)**: Create a basic Spring Boot project with Spring Web, JPA, H2 database, and CRUD controllers.

## How to Run the Projects

### Running inside an IDE (VS Code / IntelliJ IDEA)
1. Open the project root folder.
2. Open the main class file (e.g., `ex1/src/main/java/com/library/LibraryManagementApplication.java`).
3. Click the **Run** button (or press `F5` / `Ctrl + F5`) to launch the application context.

### Running via Maven Command Line
Navigate to the specific exercise directory (e.g., `ex1`):
```bash
cd ex1
```

#### For Core Exercises (ex1 - ex8)
Compile and execute using the executive plugin:
```bash
mvn compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
```

#### For Spring Boot Exercise (ex9)
Run the Spring Boot application server:
```bash
mvn spring-boot:run
```
Once started, the REST API endpoints can be tested at:
* **Retrieve books**: `GET http://localhost:8080/api/books`
* **Create book**: `POST http://localhost:8080/api/books`

