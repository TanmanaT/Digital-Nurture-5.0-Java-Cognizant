# Algorithms and Data Structures - 7 Hands-On Exercises

Welcome to the Algorithms and Data Structures hands-on workspace. This project showcases the implementation of 7 core algorithms and data structures in Java, including search, sorting, lists, recursion, and key-value maps.

---

## 🛠️ Tech Stack & Setup
- **Programming Language**: Java (JDK 8 or higher)
- **Structure**: Flat source directories under `src` in each project folder
- **Execution**: CLI compiler (`javac`) and execution (`java`)

---

## 📂 Project Structures (Hands-On Directory Map)

1. **[InventoryManagementSystem](./InventoryManagementSystem)**: Focuses on choosing appropriate data structures (e.g. `HashMap`) to store and perform product lookup/add/update/delete operations efficiently.
2. **[EcommerceSearch](./EcommerceSearch)**: Implements Linear Search and Binary Search algorithms to compare their performance under asymptotic notations.
3. **[SortingOrders](./SortingOrders)**: Implements Bubble Sort and Quick Sort to sort customer orders by price, analyzing the time complexities.
4. **[EmployeeManagementSystem](./EmployeeManagementSystem)**: Shows array representation in memory and implements basic operations (add, search, traverse, delete) on employee records.
5. **[TaskManagementSystem](./TaskManagementSystem)**: Builds a custom Singly Linked List from scratch to manage tasks and compares dynamic lists to static arrays.
6. **[LibraryManagementSystem](./LibraryManagementSystem)**: Implements Linear Search and Binary Search on book records by title for catalog search efficiency.
7. **[FinancialForecasting](./FinancialForecasting)**: Implements a recursive growth forecasting algorithm and discusses recursive tree heights, time complexities, and memoization/iterative optimizations.

---

## 🚀 Execution Guide

To compile and run any of the exercises, navigate to the target directory and run the following commands in your shell:

### Step 1: Navigate to the target directory
```powershell
cd "Engineering_Concepts/Algorithms and Data Structures/InventoryManagementSystem"
```

### Step 2: Compile the Java classes
```powershell
javac -d bin src/*.java
```

### Step 3: Run the Test class
```powershell
java -cp bin InventoryTest
```
*(Replace `InventoryTest` with the appropriate main test class name for each project).*
