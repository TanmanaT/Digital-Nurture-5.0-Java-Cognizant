-- Exercise 6: Cursors
-- Scenario 1: Generate monthly statements for all customers.
-- Question: Write a PL/SQL block using an explicit cursor GenerateMonthlyStatements that retrieves 
-- all transactions for the current month and prints a statement for each customer.

DECLARE
    -- Explicit cursor to retrieve transactions for the current month with customer names
    CURSOR c_monthly_transactions IS
        SELECT c.Name, c.CustomerID, t.TransactionID, t.AccountID, 
               t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');

    v_prev_customer_id NUMBER := -9999;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- MONTHLY STATEMENTS FOR CURRENT MONTH ---');
    
    FOR rec IN c_monthly_transactions LOOP
        -- Print header if customer changes
        IF v_prev_customer_id != rec.CustomerID THEN
            DBMS_OUTPUT.PUT_LINE('-------------------------------------------');
            DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' (ID: ' || rec.CustomerID || ')');
            DBMS_OUTPUT.PUT_LINE('-------------------------------------------');
            v_prev_customer_id := rec.CustomerID;
        END IF;

        -- Print transaction details
        DBMS_OUTPUT.PUT_LINE('  Tx ID: ' || rec.TransactionID || 
                             ' | Account: ' || rec.AccountID || 
                             ' | Type: ' || rec.TransactionType || 
                             ' | Amount: $' || rec.Amount || 
                             ' | Date: ' || TO_CHAR(rec.TransactionDate, 'YYYY-MM-DD'));
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('-------------------------------------------');
END;
/
