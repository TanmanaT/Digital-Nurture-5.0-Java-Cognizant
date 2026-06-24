# Exercise 5: Triggers

## Problem Description
This exercise demonstrates implementing active database triggers that automatically run on specific events like `INSERT` or `UPDATE` statements.

1. **Scenario 1 (UpdateCustomerLastModified)**: Automatically updates the `LastModified` column of `Customers` to the current system date whenever a row is updated.
2. **Scenario 2 (LogTransaction)**: Inserts transaction audit records into the `AuditLog` table whenever a row is added to the `Transactions` table.
3. **Scenario 3 (CheckTransactionRules)**: Verifies that deposits are positive, and withdrawals do not exceed account balances before inserts.

## Topics Covered
- Database Triggers (`CREATE OR REPLACE TRIGGER`)
- Trigger timings (`BEFORE` vs `AFTER`)
- Row-level triggers (`FOR EACH ROW`)
- Pseudo-records (`:new` and `:old`)
- Validation constraints on incoming data

## Implementation Details
- **`Scenario 1.sql`**: A `BEFORE UPDATE` trigger on `Customers` dynamically assigning `:new.LastModified := SYSDATE;`.
- **`Scenario 2.sql`**: An `AFTER INSERT` trigger on `Transactions` logging transaction events into `AuditLog`.
- **`Scenario 3.sql`**: A `BEFORE INSERT` trigger on `Transactions` checking the logic rules and throwing application errors if business logic fails.
