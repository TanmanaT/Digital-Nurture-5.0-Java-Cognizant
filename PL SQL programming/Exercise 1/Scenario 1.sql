-- Exercise 1: Control Structures
-- Scenario 1: Apply a discount to loan interest rates for customers above 60 years old.
-- Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

DECLARE
    -- Cursor to fetch loan details and customer dates of birth for calculation
    CURSOR c_customer_loans IS
        SELECT l.LoanID, l.CustomerID, l.InterestRate, c.Name, c.DOB
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;
        
    v_age NUMBER;
BEGIN
    FOR rec IN c_customer_loans LOOP
        -- Calculate age in years
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        
        -- Check if age is above 60
        IF v_age > 60 THEN
            -- Apply 1% discount (e.g. subtract 1 from current InterestRate)
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || rec.LoanID || 
                                 ' for Customer: ' || rec.Name || ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
