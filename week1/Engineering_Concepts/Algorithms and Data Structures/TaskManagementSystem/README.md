# Exercise 5: Task Management System

## Scenario
You are developing a task management system where tasks need to be added, deleted, searched, and traversed efficiently.

## Core Concepts
- **Singly Linked List**: A linear data structure where elements (Nodes) are not stored in contiguous memory locations. Instead, each Node points to the next Node via a reference (`next`).
- **Time Complexity Analysis**:
  - **Add (at end)**: O(N) (or O(1) if a tail pointer is maintained). Here it's implemented as O(N) to demonstrate standard list traversal.
  - **Search**: O(N) (requires traversing the list to locate the target node).
  - **Traverse**: O(N) (visiting all nodes sequentially).
  - **Delete**: O(N) (requires O(N) to locate the element, but deleting is O(1) by updating the pointer references: `prev.next = curr.next`).

## Discussion on Arrays vs. Linked Lists
- **Dynamic Size**: Linked Lists are completely dynamic and can grow or shrink at runtime without costly resizing operations.
- **Insert/Delete**: Inserting or deleting a Node does not require shifting elements (unlike arrays), making it a simple pointer update, though finding the element still takes O(N) time.
- **Memory Allocation**: Linked Lists consume slightly more memory per element due to the storage of reference pointers.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin TaskTest
```
