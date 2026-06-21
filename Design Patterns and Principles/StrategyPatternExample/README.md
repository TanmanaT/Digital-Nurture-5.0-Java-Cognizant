# Strategy Pattern Example

## Scenario
You are developing a payment system where different payment methods (e.g., Credit Card, PayPal) can be selected dynamically at runtime.

## Core Concepts
- **Strategy Pattern**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
- **Open/Closed Principle**: New payment types can be added without modifying existing context/controller logic.

## Class Map
- `PaymentStrategy`: Common interface for algorithms.
- `CreditCardPayment`, `PayPalPayment`: Interchangeable concrete strategies.
- `PaymentContext`: Context class executing the chosen strategy.
- `StrategyPatternTest`: Driver class testing runtime switching.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin StrategyPatternTest
```
