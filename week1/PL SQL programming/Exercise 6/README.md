# Exercise 6: Cursors

## Problem Description
This exercise focuses on using explicit cursors to navigate through query result sets row by row.

1. **Scenario 1 (GenerateMonthlyStatements)**: Explicit cursor `GenerateMonthlyStatements` that retrieves and prints transaction details for all customers during the current month.
2. **Scenario 2 (ApplyAnnualFee)**: Explicit cursor `ApplyAnnualFee` that deducts maintenance fees from accounts.
3. **Scenario 3 (UpdateLoanInterestRates)**: Explicit cursor `UpdateLoanInterestRates` that adjusts loan rates based on active policies.

## Topics Covered
- Explicit Cursors (`CURSOR c_name IS ...`)
- Cursor loop processing (`FOR rec IN ...`)
- Updating records using cursors (`FOR UPDATE` and `WHERE CURRENT OF`)
- Printing text output (`DBMS_OUTPUT.PUT_LINE`)

## Implementation Details
- **`Scenario 1.sql`**: Collects monthly transactions and loops through the cursor to display a formatted statement to standard output.
- **`Scenario 2.sql`**: Deducts a flat fee of $50 from each account record using `WHERE CURRENT OF`.
- **`Scenario 3.sql`**: Adjusts interest rates by 0.5% (loans > $15,000) or 0.25% (loans <= $15,000) inside a cursor loop.
