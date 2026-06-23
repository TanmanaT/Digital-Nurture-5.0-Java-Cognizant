# Exercise 3: Sorting Customer Orders

## Scenario
You are sorting customer orders by their total price on an e-commerce platform to prioritize high-value orders.

## Sorting Algorithms

1. **Bubble Sort**:
   - A simple comparison-based algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
   - Time Complexity:
     - **Best Case**: O(N) (array is already sorted).
     - **Average Case**: O(N^2).
     - **Worst Case**: O(N^2).
   - Space Complexity: O(1) (In-place sort).

2. **Quick Sort**:
   - A divide-and-conquer algorithm that selects a 'pivot' element, partitions the array around it, and recursively sorts the sub-arrays.
   - Time Complexity:
     - **Best Case**: O(N log N).
     - **Average Case**: O(N log N).
     - **Worst Case**: O(N^2) (occurs when the pivot selection consistently splits the array into unbalanced partitions).
   - Space Complexity: O(log N) (recursive stack space).

## Discussion
Quick Sort is significantly faster and more scalable than Bubble Sort for larger datasets because of its logarithmic recursion depth (O(N log N)) compared to Bubble Sort's quadratic nested loops (O(N^2)). For production systems, Quick Sort (or hybrid algorithms like Timsort) is preferred.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin SortingTest
```
