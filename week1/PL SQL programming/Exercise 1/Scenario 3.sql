-- Exercise 1: Control Structures
-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
-- Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, l.EndDate, c.Name, c.CustomerID
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- LOAN DUE REMINDERS ---');
    FOR rec IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ' (ID: ' || rec.CustomerID || 
                             '), your Loan ID: ' || rec.LoanID || ' is due on ' || 
                             TO_CHAR(rec.EndDate, 'YYYY-MM-DD') || '. Please ensure payment is arranged.');
    END LOOP;
END;
/
