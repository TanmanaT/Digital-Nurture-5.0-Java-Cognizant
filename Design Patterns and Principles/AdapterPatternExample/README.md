# Adapter Pattern Example

## Scenario
You are developing a payment processing system that needs to integrate with multiple third-party payment gateways with different interfaces.

## Core Concepts
- **Adapter Pattern**: Converts the interface of a class into another interface that clients expect. It lets classes work together that couldn't otherwise due to incompatible interfaces.
- **Target Interface**: The unified contract the client system uses (`PaymentProcessor`).
- **Adaptees**: External legacy or third-party classes (`PaypalGateway`, `StripeGateway`).
- **Adapters**: Bridge classes that implement the target interface and delegate work to specific gateways.

## Class Map
- `PaymentProcessor`: Common Target Interface.
- `PaypalGateway`, `StripeGateway`: Incompatible third-party gateway interfaces (Adaptees).
- `PaypalAdapter`, `StripeAdapter`: Wrappers matching target and adaptee (Adapters).
- `AdapterPatternTest`: Driver class testing gateway operations.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin AdapterPatternTest
```
