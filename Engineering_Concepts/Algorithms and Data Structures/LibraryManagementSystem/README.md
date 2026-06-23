# Exercise 6: Library Management System

## Scenario
You are developing a library management system where users need to search for books by title or author efficiently in a catalog.

## Search Algorithms

1. **Linear Search**:
   - Compares the target title against every book in the array sequentially.
   - Time Complexity: O(N) (worst and average case).
   - Works on any unsorted list.

2. **Binary Search**:
   - Repeatedly divides the sorted search interval in half.
   - Time Complexity: O(log N) (worst and average case).
   - **Prerequisite**: The list must be sorted alphabetically by title.

## Comparison & Usage
- Use **Linear Search** when the data set is small or unsorted, and sorting overhead isn't justified.
- Use **Binary Search** for larger databases where lookups are frequent and the list is kept sorted.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin LibraryTest
```
