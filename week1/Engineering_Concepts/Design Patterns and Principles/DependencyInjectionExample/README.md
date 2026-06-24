# Dependency Injection Example

## Scenario
You are developing a customer management application where the service class depends on a repository class. You need to use Dependency Injection to manage this dependency.

## Core Concepts
- **Dependency Injection**: A technique in which an object receives other objects that it depends on. This passes concrete dependencies into components instead of hardcoding them inside.
- **Constructor Injection**: Injecting dependencies directly via constructors, facilitating unit testing and mock substitution.

## Class Map
- `CustomerRepository`: Repository contract interface.
- `CustomerRepositoryImpl`: Mock database persistence repository class.
- `CustomerService`: High-level business logic service class.
- `DependencyInjectionTest`: Driver injecting dependency and fetching customer names.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin DependencyInjectionTest
```
