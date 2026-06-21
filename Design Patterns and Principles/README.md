# Design Patterns and Principles - 11 Hands-On Exercises

Welcome to the Design Patterns and Principles hands-on workspace. This project showcases the complete implementation of 11 core design patterns and architectural principles in Java.

---

## 🛠️ Tech Stack & Setup
- **Programming Language**: Java (JDK 8 or higher)
- **Structure**: Flat source directories under `src` in each project folder
- **Execution**: CLI compiler (`javac`) and execution (`java`)

---

## 📂 Project Structures (Hands-On Directory Map)

1. **[SingletonPatternExample](./SingletonPatternExample)**: Ensures a logging utility class has only one instance throughout the application lifecycle.
2. **[FactoryMethodPatternExample](./FactoryMethodPatternExample)**: Implements a document management system to dynamically create Word, PDF, and Excel documents.
3. **[BuilderPatternExample](./BuilderPatternExample)**: Uses the Builder pattern to construct complex `Computer` objects with optional attributes.
4. **[AdapterPatternExample](./AdapterPatternExample)**: Integrates multiple third-party payment gateways (PayPal, Stripe) via custom adapters.
5. **[DecoratorPatternExample](./DecoratorPatternExample)**: Dynamically adds notification channels (SMS, Slack) to a base Email notifier wrapper.
6. **[ProxyPatternExample](./ProxyPatternExample)**: Implements lazy initialization and caching for an image viewer loading remote resources.
7. **[ObserverPatternExample](./ObserverPatternExample)**: Implements a stock market monitoring system where multiple observers are notified on stock price updates.
8. **[StrategyPatternExample](./StrategyPatternExample)**: Implements dynamic selection of payment methods (Credit Card, PayPal) at runtime.
9. **[CommandPatternExample](./CommandPatternExample)**: Decouples request invokers (`RemoteControl`) and receivers (`Light`) using commands.
10. **[MVCPatternExample](./MVCPatternExample)**: Separates student data management concerns into Model (`Student`), View (`StudentView`), and Controller (`StudentController`).
11. **[DependencyInjectionExample](./DependencyInjectionExample)**: Uses constructor injection to supply repository dependencies to service components.

---

## 🚀 Execution Guide

To compile and run any of the design pattern exercises, navigate to the target directory and run the following commands in your shell:

### Step 1: Navigate to the target directory
```powershell
cd "Design Patterns and Principles/SingletonPatternExample"
```

### Step 2: Compile the Java classes
```powershell
javac -d bin src/*.java
```

### Step 3: Run the Test class
```powershell
java -cp bin SingletonTest
```
*(Replace `SingletonTest` with the appropriate main test class name for each project).*
