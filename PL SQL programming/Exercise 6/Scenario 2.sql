-- Exercise 6: Cursors
-- Scenario 2: Apply annual fee to all accounts.
-- Question: Write a PL/SQL block using an explicit cursor ApplyAnnualFee that deducts 
-- an annual maintenance fee from the balance of all accounts.

DECLARE
    -- Cursor to select all accounts for fee deduction
    CURSOR c_accounts IS
        SELECT AccountID, Balance, CustomerID
        FROM Accounts
        FOR UPDATE;
        
    v_annual_fee CONSTANT NUMBER := 50.00; -- Annual maintenance fee amount
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- APPLYING ANNUAL MAINTENANCE FEE ---');
    FOR rec IN c_accounts LOOP
        -- Deduct fee from account balance
        UPDATE Accounts
        SET Balance = Balance - v_annual_fee,
            LastModified = SYSDATE
        WHERE CURRENT OF c_accounts;
        
        DBMS_OUTPUT.PUT_LINE('Deducted $' || v_annual_fee || ' fee from Account ID: ' || rec.AccountID || 
                             '. New Balance: $' || (rec.Balance - v_annual_fee));
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fee processing completed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing annual fees: ' || SQLERRM);
END;
/
