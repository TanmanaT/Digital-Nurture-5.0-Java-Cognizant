# Builder Pattern Example

## Scenario
You are developing a system to create complex objects such as a Computer with multiple optional parts.

## Core Concepts
- **Builder Pattern**: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
- **Fluent API**: Builder methods return the builder instance (`return this;`), enabling clean, chained object configuration.
- **Immutability**: Once `build()` is called, a fully configured immutable `Computer` object is returned.

## Class Map
- `Computer`: Product class with optional attributes (CPU, RAM, Storage, GPU, WiFi).
- `Computer.Builder`: Static nested builder class holding setup methods.
- `BuilderPatternTest`: Driver class verifying custom computer configurations.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin BuilderPatternTest
```
