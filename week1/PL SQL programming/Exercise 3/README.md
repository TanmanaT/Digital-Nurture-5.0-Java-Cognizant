# Exercise 3: Stored Procedures

## Problem Description
This exercise demonstrates designing reusable database procedures in PL/SQL that implement core banking operations.

1. **Scenario 1 (ProcessMonthlyInterest)**: Calculates and updates the balance of all savings accounts by applying a 1% monthly interest rate.
2. **Scenario 2 (UpdateEmployeeBonus)**: Updates employee salaries in a specified department with a custom bonus percentage.
3. **Scenario 3 (TransferFunds)**: Implements account-to-account transfers with input parameter validations and raises user-defined runtime application errors.

## Topics Covered
- Stored Procedures (`CREATE OR REPLACE PROCEDURE`)
- Input parameters (`IN` mode)
- Standard updates and checking row count (`SQL%ROWCOUNT`)
- Raising application errors (`RAISE_APPLICATION_ERROR`)

## Implementation Details
- **`Scenario 1.sql`**: Applies interest calculation on accounts filtered by type `'Savings'` and commits the transaction.
- **`Scenario 2.sql`**: Accepts department name and bonus rate, verifies that employees exist in that department, and modifies their records.
- **`Scenario 3.sql`**: Performs standard transfer operations and handles errors by invoking `RAISE_APPLICATION_ERROR` with custom codes (e.g., -20001 through -20004).
