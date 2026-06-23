# Exercise 1: PL/SQL Control Structures

## Problem Description
This exercise demonstrates the use of basic conditional statements (`IF-THEN-ELSIF-ELSE`), cursor loops (`FOR loop`), and date manipulation in PL/SQL.

1. **Scenario 1 (Loan Interest Discount)**: Write a block that loops through all customers, checks their age, and if they are above 60, applies a 1% discount to their current loan interest rates.
2. **Scenario 2 (Promote to VIP)**: Write a block that iterates through all customers and sets a flag `IsVIP` to 'TRUE' for those with a balance over $10,000.
3. **Scenario 3 (Loan Due Reminders)**: Write a block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

## Topics Covered
- PL/SQL Declaring Blocks
- Explicit Cursor Loops
- Date calculations (`MONTHS_BETWEEN`, `SYSDATE`)
- `IF-THEN-ELSE` Conditional Statements
- SQL `UPDATE` Statements inside Loops

## Implementation Details
- **`Scenario 1.sql`**: Iterates through loans, calculates the borrower's age from their date of birth, and applies interest rate discounts for senior citizens (> 60 years old).
- **`Scenario 2.sql`**: Scans customer accounts and flags profiles with balances exceeding $10,000 as VIPs (`IsVIP = 'TRUE'`).
- **`Scenario 3.sql`**: Uses a joined query to output a reminder notification to stdout for any loans with an `EndDate` falling in the next 30 days.
