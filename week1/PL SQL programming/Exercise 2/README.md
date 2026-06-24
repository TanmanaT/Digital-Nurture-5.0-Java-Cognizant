# Exercise 2: PL/SQL Error Handling

## Problem Description
This exercise focuses on using standard error handling techniques in PL/SQL. It involves catching predefined system exceptions as well as custom exceptions inside stored procedures.

1. **Scenario 1 (SafeTransferFunds)**: Stored procedure `SafeTransferFunds` that transfers money between accounts, handles insufficient balances or missing accounts, logs errors, and executes rollbacks on failure.
2. **Scenario 2 (UpdateSalary)**: Stored procedure `UpdateSalary` that increases salary by a percentage. If the employee does not exist, it handles `NO_DATA_FOUND` and logs an error message.
3. **Scenario 3 (AddNewCustomer)**: Stored procedure `AddNewCustomer` that inserts a customer and intercepts primary key violations (`DUP_VAL_ON_INDEX`).

## Topics Covered
- PL/SQL Exception Handling (`EXCEPTION` block)
- Predefined Exceptions (`NO_DATA_FOUND`, `DUP_VAL_ON_INDEX`)
- Custom Exceptions (`RAISE` statement)
- Transaction boundaries (`COMMIT` and `ROLLBACK`)

## Implementation Details
- **`Scenario 1.sql`**: Performs balance checks, validates account existence, executes the transfer, and rolls back changes if a rule or balance condition is violated.
- **`Scenario 2.sql`**: Increments employee salary and utilizes a custom exception wrapper for `NO_DATA_FOUND` when the `EmployeeID` is not found.
- **`Scenario 3.sql`**: Safely handles duplicate inserts by catching `DUP_VAL_ON_INDEX` and printing an error instead of letting the application crash.
