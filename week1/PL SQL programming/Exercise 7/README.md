# Exercise 7: Packages

## Problem Description
This exercise demonstrates encapsulating related database routines (procedures, variables, and functions) into modular PL/SQL packages.

1. **Scenario 1 (CustomerManagement)**: Package to group procedures like `AddNewCustomer`, `UpdateCustomerDetails`, and the function `GetCustomerBalance`.
2. **Scenario 2 (EmployeeManagement)**: Package to group employee operations: hiring, details updating, and calculating annual salary.
3. **Scenario 3 (AccountOperations)**: Package to handle account operations: opening, closing, and calculating customer aggregate balances.

## Topics Covered
- Package Specification (`CREATE OR REPLACE PACKAGE`)
- Package Body (`CREATE OR REPLACE PACKAGE BODY`)
- Variable scope and encapsulation
- Overloading and modular architecture

## Implementation Details
- **`Scenario 1.sql`**: Implements customer management features, isolating schema updates and queries.
- **`Scenario 2.sql`**: Manages hiring, updating info, and dynamic annual salary calculations.
- **`Scenario 3.sql`**: Enforces account constraints (e.g., confirming customer existence before opening accounts) and offers utility functions to aggregate user balances.
