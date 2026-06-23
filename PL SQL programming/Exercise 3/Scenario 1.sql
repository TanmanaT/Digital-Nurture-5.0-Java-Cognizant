-- Exercise 3: Stored Procedures
-- Scenario 1: Process monthly interest for all savings accounts.
-- Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of 
-- all savings accounts by applying an interest rate of 1% to the current balance.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_interest_rate CONSTANT NUMBER := 0.01; -- 1% interest rate
BEGIN
    -- Update all savings accounts, increasing their balance by 1%
    UPDATE Accounts
    SET Balance = Balance * (1 + v_interest_rate),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully applied 1% monthly interest to all Savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error applying monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/
