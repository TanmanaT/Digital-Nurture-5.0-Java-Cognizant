# MVC Pattern Example

## Scenario
You are developing a simple web application for managing student records using the Model-View-Controller architectural pattern.

## Core Concepts
- **Model-View-Controller**: Separates an application into three main logical components:
  - **Model**: Represents the data structure (`Student`).
  - **View**: Renders visual representation of data (`StudentView`).
  - **Controller**: Intermediary that handles user requests, updates Model, and refreshes View (`StudentController`).

## Class Map
- `Student`: Model class holding details (id, name, grade).
- `StudentView`: View class printing formatting records.
- `StudentController`: Controller coordinating flow.
- `MVCPatternTest`: Driver class checking updates.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin MVCPatternTest
```
