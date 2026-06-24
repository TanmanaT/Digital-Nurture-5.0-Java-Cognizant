# Exercise 2: E-commerce Platform Search Function

## Scenario
You are building the search functionality of an e-commerce platform where search needs to be optimized for fast performance across catalog databases.

## Search Algorithms

1. **Linear Search**:
   - Traverses the array sequentially from start to end.
   - Works on unsorted arrays.
   - Time Complexity:
     - **Best Case**: O(1) (target is the first element).
     - **Average Case**: O(N) (target is in the middle).
     - **Worst Case**: O(N) (target is at the end or not present).

2. **Binary Search**:
   - Divides the search interval in half recursively.
   - **Prerequisite**: The array MUST be sorted.
   - Time Complexity:
     - **Best Case**: O(1) (target is at the exact middle element).
     - **Average Case**: O(log N).
     - **Worst Case**: O(log N).

## Discussion
While Linear Search is simple and doesn't require sorting overhead, Binary Search is exponentially faster for large datasets. For an e-commerce platform with thousands or millions of products, sorting the array once (or maintaining a sorted list/index) and using Binary Search (O(log N)) is the optimal choice.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin SearchTest
```
