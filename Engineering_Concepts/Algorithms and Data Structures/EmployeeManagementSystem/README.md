# Exercise 4: Employee Management System

## Scenario
You are developing an employee management system where efficient array representation, indexing, and basic record operations must be handled in memory.

## Core Concepts
- **Array Representation**: Arrays are contiguous blocks of memory where each element is accessed via an index. This enables fast direct access but makes insertion and deletion expensive since elements must be shifted.
- **Time Complexity Analysis**:
  - **Add**: O(1) (when inserting at the next empty slot; if capacity resizing is needed it could be O(N)).
  - **Search**: O(N) (linear scan to search by attribute other than array index).
  - **Traverse**: O(N) (visiting all elements).
  - **Delete**: O(N) (requires scanning to locate the item, then shifting elements left to maintain contiguous order).

## Discussion on Limitations
1. **Fixed Size**: Once initialized, standard Java arrays cannot be resized.
2. **Costly Deletions/Insertions**: Shifting elements requires O(N) steps.
3. **Memory Overhead**: If capacity is overallocated, unused memory is wasted.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin EmployeeTest
```
