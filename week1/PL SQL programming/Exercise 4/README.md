# Exercise 4: Functions

## Problem Description
This exercise demonstrates designing PL/SQL functions to perform calculations and return values to the caller.

1. **Scenario 1 (CalculateAge)**: A function that takes a date of birth and returns the age in years.
2. **Scenario 2 (CalculateMonthlyInstallment)**: A function that calculates the monthly installment (EMI) of a loan given the principal, interest rate, and duration.
3. **Scenario 3 (HasSufficientBalance)**: A function returning a BOOLEAN indicating if an account has a balance greater than or equal to a specified transaction amount.

## Topics Covered
- PL/SQL Functions (`CREATE OR REPLACE FUNCTION`)
- Return data types (including `BOOLEAN`)
- Advanced formulas (`POWER` function)
- Input parameter constraints

## Implementation Details
- **`Scenario 1.sql`**: Computes standard age dynamically based on current system time.
- **`Scenario 2.sql`**: Uses the standard amortization formula: $M = P \cdot \frac{r(1+r)^n}{(1+r)^n - 1}$ while safeguarding against division by zero (e.g. 0% interest).
- **`Scenario 3.sql`**: Checks balance requirements and returns a BOOLEAN flag, useful in procedure/trigger rule validations.
