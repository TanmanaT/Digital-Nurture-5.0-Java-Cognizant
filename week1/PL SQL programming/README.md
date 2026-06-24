# PL/SQL Programming - 7 Hands-On Exercises

This workspace contains modular implementations of PL/SQL programming exercises, structured hierarchically to demonstrate key database concepts like Control Structures, Error Handling, Stored Procedures, Functions, Triggers, Cursors, and Packages.

---

## 🛠️ Database Schema & Setup
- **Database Engine**: Oracle Database (or equivalent SQL client supporting PL/SQL)
- **Design Pattern**: Modular SQL scripts structured by exercise and scenario
- **Database Schema**: Defined in [`schema.sql`](./schema.sql)
- **Sample Data**: Defined in [`sample_data.sql`](./sample_data.sql)

---

## 📂 Project Structures (Hands-On Directory Map)

1. **[Exercise 1: Control Structures](./Exercise%201)**: PL/SQL blocks using loops and conditional logic.
   - **Scenario 1**: 1% loan interest rate discount for senior citizens (> 60 years old).
   - **Scenario 2**: Promotion of customers to VIP status based on balance (> $10,000).
   - **Scenario 3**: Upcoming loan due-date reminders (next 30 days).
2. **[Exercise 2: Error Handling](./Exercise%202)**: Stored procedures with robust error catching and log messages.
   - **Scenario 1**: Safe fund transfer procedure with transaction rollbacks.
   - **Scenario 2**: Employee salary updates with non-existent ID checks.
   - **Scenario 3**: Adding new customer records with duplicate key handling.
3. **[Exercise 3: Stored Procedures](./Exercise%203)**: Processing and updating data using reusable DB logic.
   - **Scenario 1**: Savings account interest application (1% monthly interest).
   - **Scenario 2**: Employee bonus updates by department.
   - **Scenario 3**: Account-to-account fund transfer with balance verification.
4. **[Exercise 4: Functions](./Exercise%204)**: PL/SQL functions to calculate or evaluate database conditions.
   - **Scenario 1**: Calculate customer age from Date of Birth.
   - **Scenario 2**: Compute monthly loan installment using amortization formulas.
   - **Scenario 3**: Check for sufficient account balance before transactions.
5. **[Exercise 5: Triggers](./Exercise%205)**: Automating tasks based on table events.
   - **Scenario 1**: Automatically update a customer's `LastModified` timestamp on edit.
   - **Scenario 2**: Create audit trail records in `AuditLog` on transaction insertion.
   - **Scenario 3**: Enforce business rules for deposit and withdrawal amounts.
6. **[Exercise 6: Cursors](./Exercise%206)**: Explicit cursors for record-by-record iteration.
   - **Scenario 1**: Generate monthly account statements.
   - **Scenario 2**: Deduct annual maintenance fees from accounts.
   - **Scenario 3**: Policy-based update of loan interest rates.
7. **[Exercise 7: Packages](./Exercise%207)**: Encapsulating related subprograms (procedures, functions) together.
   - **Scenario 1**: `CustomerManagement` package for operations like adding, editing, and checking balances.
   - **Scenario 2**: `EmployeeManagement` package for hiring and calculating annual salary.
   - **Scenario 3**: `AccountOperations` package for opening, closing, and checking customer aggregate balances.

---

## 🚀 Execution Guide

To run any script in your Oracle/SQL environment:
1. First run the database creation script:
   ```sql
   @schema.sql
   ```
2. Insert sample test data:
   ```sql
   @sample_data.sql
   ```
3. Load and execute the target script, e.g.:
   ```sql
   @"Exercise 1/Scenario 1.sql"
   ```
