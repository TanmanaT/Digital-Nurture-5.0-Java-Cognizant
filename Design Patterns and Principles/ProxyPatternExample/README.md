# Proxy Pattern Example

## Scenario
You are developing an image viewer application that loads images from a remote server. Lazy initialization and caching are needed to avoid redundant loading.

## Core Concepts
- **Proxy Pattern**: Provides a surrogate or placeholder for another object to control access to it.
- **Lazy Loading**: The real object is not created until it is strictly required.
- **Caching**: The proxy holds a reference to the real object so subsequent calls bypass the expensive initialization steps.

## Class Map
- `Image`: Common Subject interface.
- `RealImage`: Expensive resource simulating remote server retrieval.
- `ProxyImage`: Proxy class managing lazy load and reference caching.
- `ProxyPatternTest`: Driver class verifying load times.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin ProxyPatternTest
```
