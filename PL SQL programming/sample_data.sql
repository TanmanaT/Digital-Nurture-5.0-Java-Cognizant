-- Sample Data Insertion Script for PL/SQL Exercises

-- Clean up any existing data
DELETE FROM AuditLog;
DELETE FROM Employees;
DELETE FROM Loans;
DELETE FROM Transactions;
DELETE FROM Accounts;
DELETE FROM Customers;

-- Insert Customers (Including aged > 60 for Exercise 1 Scenario 1, and balance > 10000 for VIP check)
-- John Doe: Age ~41, Balance 1000
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE, 'FALSE');

-- Jane Smith: Age ~36, Balance 15000 (VIP candidate)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 15000, SYSDATE, 'FALSE');

-- Robert Fowler: Age ~66, Balance 500
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (3, 'Robert Fowler', TO_DATE('1960-01-10', 'YYYY-MM-DD'), 500, SYSDATE, 'FALSE');

-- Margaret Thatcher: Age ~71, Balance 12000 (VIP candidate and > 60)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (4, 'Margaret Thatcher', TO_DATE('1955-03-25', 'YYYY-MM-DD'), 12000, SYSDATE, 'FALSE');


-- Insert Accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 15000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (3, 3, 'Savings', 500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (4, 4, 'Savings', 12000, SYSDATE);


-- Insert Transactions
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');


-- Insert Loans (Including loans due in next 30 days for Exercise 1 Scenario 3)
-- Loan 1: Standard loan for John Doe
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

-- Loan 2: Loan for Robert Fowler (aged > 60)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 3, 10000, 6.5, SYSDATE, ADD_MONTHS(SYSDATE, 24));

-- Loan 3: Loan due in next 15 days (Reminder candidate)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 2, 25000, 4.0, ADD_MONTHS(SYSDATE, -11.5), SYSDATE + 15);


-- Insert Employees
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;
