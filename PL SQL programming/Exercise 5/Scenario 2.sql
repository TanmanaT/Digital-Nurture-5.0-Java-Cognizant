-- Exercise 5: Triggers
-- Scenario 2: Maintain an audit log for all transactions.
-- Question: Write a trigger LogTransaction that inserts a record into an AuditLog table 
-- whenever a transaction is inserted into the Transactions table.

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        TransactionID, 
        AccountID, 
        TransactionDate, 
        Amount, 
        TransactionType, 
        LogDate
    )
    VALUES (
        :new.TransactionID, 
        :new.AccountID, 
        :new.TransactionDate, 
        :new.Amount, 
        :new.TransactionType, 
        SYSDATE
    );
END;
/
