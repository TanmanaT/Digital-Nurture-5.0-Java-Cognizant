# Design Patterns and Principles - 11 Hands-On Exercises

Welcome to the Design Patterns and Principles hands-on workspace. This project showcases the complete implementation of 11 core design patterns and architectural principles in Java.

---

## 🛠️ Tech Stack & Setup
- **Programming Language**: Java (JDK 8 or higher)
- **Structure**: Flat source directories under `src` in each project folder
- **Execution**: CLI compiler (`javac`) and execution (`java`)

---

## 📂 Project Structures (Hands-On Directory Map)

1. **[SingletonPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/SingletonPatternExample)**: Ensures a logging utility class has only one instance throughout the application lifecycle.
2. **[FactoryMethodPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/FactoryMethodPatternExample)**: Implements a document management system to dynamically create Word, PDF, and Excel documents.
3. **[BuilderPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/BuilderPatternExample)**: Uses the Builder pattern to construct complex `Computer` objects with optional attributes.
4. **[AdapterPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/AdapterPatternExample)**: Integrates multiple third-party payment gateways (PayPal, Stripe) via custom adapters.
5. **[DecoratorPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/DecoratorPatternExample)**: Dynamically adds notification channels (SMS, Slack) to a base Email notifier wrapper.
6. **[ProxyPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/ProxyPatternExample)**: Implements lazy initialization and caching for an image viewer loading remote resources.
7. **[ObserverPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/ObserverPatternExample)**: Implements a stock market monitoring system where multiple observers are notified on stock price updates.
8. **[StrategyPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/StrategyPatternExample)**: Implements dynamic selection of payment methods (Credit Card, PayPal) at runtime.
9. **[CommandPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/CommandPatternExample)**: Decouples request invokers (`RemoteControl`) and receivers (`Light`) using commands.
10. **[MVCPatternExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/MVCPatternExample)**: Separates student data management concerns into Model (`Student`), View (`StudentView`), and Controller (`StudentController`).
11. **[DependencyInjectionExample](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Design%20Patterns%20and%20Principles/DependencyInjectionExample)**: Uses constructor injection to supply repository dependencies to service components.

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
