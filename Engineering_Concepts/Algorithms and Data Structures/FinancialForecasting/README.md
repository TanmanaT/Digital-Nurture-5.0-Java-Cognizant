# Exercise 7: Financial Forecasting

## Scenario
You are developing a financial forecasting tool that predicts future values based on past data and growth rates using recursive approaches.

## Core Concepts
- **Recursion**: A programming technique where a method calls itself to solve a smaller sub-problem until it reaches a base case.
- **Recursive formula**: `calculateFutureValue(PV, r, n) = calculateFutureValue(PV * (1 + r), r, n - 1)` with base case `calculateFutureValue(PV, r, 0) = PV`.

## Time & Space Complexity

| Approach | Time Complexity | Space Complexity |
|----------|-----------------|------------------|
| Recursive| O(N)            | O(N) (due to call stack space) |
| Iterative| O(N)            | O(1) |

## Discussion on Optimization
Although the recursive approach simplifies logic, it incurs a space overhead of O(N) on the call stack. For a very large number of periods (years), this can cause a `StackOverflowError`. 
To optimize:
1. **Iterative approach**: Transforms recursion into a loop, reducing auxiliary space to O(1).
2. **Memoization / Fast Exponentiation**: If calculating compound sub-problems, caching results or using binary exponentiation ($O(\log N)$) can significantly optimize execution.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin ForecastingTest
```
