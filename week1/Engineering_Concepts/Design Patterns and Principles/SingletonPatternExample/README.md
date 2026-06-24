# Singleton Pattern Example

## Scenario
You need to ensure that a logging utility class in your application has only one instance throughout the application lifecycle to ensure consistent logging.

## Core Concepts
- **Singleton Pattern**: Restricts the instantiation of a class to one single instance and provides a global point of access to it.
- **Lazy Initialization**: The instance is only created when it is first requested.
- **Thread Safety**: Uses double-checked locking inside the `getInstance()` method to handle concurrent access safely.

## Class Map
- `Logger`: The Singleton class representing the logging utility.
- `SingletonTest`: Driver class to verify that multiple requests for the Logger instance return the exact same object reference.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin SingletonTest
```
