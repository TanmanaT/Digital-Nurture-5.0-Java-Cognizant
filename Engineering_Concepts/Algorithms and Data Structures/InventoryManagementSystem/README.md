# Exercise 1: Inventory Management System

## Scenario
You are developing an inventory management system for a warehouse where efficient data storage and retrieval are crucial to manage large inventories.

## Core Concepts
- **Data Structures**: Chosen a `HashMap` key-value store to map product IDs (`String`) to `Product` objects.
- **Why HashMap?**: Unlike lists or arrays which require linear scanning (O(N) complexity) to locate, update, or delete an item, `HashMap` uses hashing to provide O(1) time complexity for these primary operations.

## Time Complexity Analysis

| Operation | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity |
|-----------|---------------------------|-------------------------|------------------|
| Add       | O(1)                      | O(N)                    | O(1)             |
| Update    | O(1)                      | O(N)                    | O(1)             |
| Delete    | O(1)                      | O(N)                    | O(1)             |
| Search/Get| O(1)                      | O(N)                    | O(1)             |

*Note: Worst-case O(N) occurs if there are hash collisions causing all keys to fall into the same bucket (though modern Java 8+ uses balanced trees for bucket overflows, reducing the worst-case to O(log N)).*

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin InventoryTest
```
