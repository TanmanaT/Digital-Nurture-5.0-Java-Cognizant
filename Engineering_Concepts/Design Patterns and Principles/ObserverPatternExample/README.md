# Observer Pattern Example

## Scenario
You are developing a stock market monitoring application where multiple clients (Mobile, Web) need to be notified whenever stock prices change.

## Core Concepts
- **Observer Pattern**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **Publish-Subscribe**: Subject publishes events; Observers register to subscribe/listen.

## Class Map
- `Stock`: Subject interface for registering/deregistering observers.
- `StockMarket`: Concrete publisher keeping observer list.
- `Observer`: Subscriber callback interface.
- `MobileApp`, `WebApp`: Concrete observers showing custom notifications.
- `ObserverPatternTest`: Driver class verifying event dispatching.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin ObserverPatternTest
```
