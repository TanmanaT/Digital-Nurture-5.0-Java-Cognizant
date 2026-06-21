# Decorator Pattern Example

## Scenario
You are developing a notification system where notifications can be sent via multiple channels (e.g., Email, SMS, Slack) dynamically.

## Core Concepts
- **Decorator Pattern**: Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
- **Composition over Inheritance**: Features are stacked by wrapping objects in other objects, avoiding class explosion.

## Class Map
- `Notifier`: Component interface.
- `EmailNotifier`: Concrete component implementation.
- `NotifierDecorator`: Base abstract decorator wrapping a component.
- `SMSNotifierDecorator`, `SlackNotifierDecorator`: Concrete decorators executing extra tasks.
- `DecoratorPatternTest`: Driver class showing stacked wrappers.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin DecoratorPatternTest
```
