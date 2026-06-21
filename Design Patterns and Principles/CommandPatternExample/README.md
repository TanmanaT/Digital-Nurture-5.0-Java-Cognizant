# Command Pattern Example

## Scenario
You are developing a home automation system where commands can be issued to turn devices (like light controllers) on or off.

## Core Concepts
- **Command Pattern**: Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.
- **Decoupling**: The invoker (`RemoteControl`) does not know the specific operations of the receiver (`Light`). It only executes the generic `execute()` method.

## Class Map
- `Command`: Command Interface.
- `Light`: Receiver class.
- `LightOnCommand`, `LightOffCommand`: Concrete commands wrapping the receiver.
- `RemoteControl`: Invoker class triggering execution.
- `CommandPatternTest`: Driver class testing remote button triggers.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin CommandPatternTest
```
