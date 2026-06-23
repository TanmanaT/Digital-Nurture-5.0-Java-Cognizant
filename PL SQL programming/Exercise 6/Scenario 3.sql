-- Exercise 6: Cursors
-- Scenario 3: Update the interest rate for all loans based on a new policy.
-- Question: Write a PL/SQL block using an explicit cursor UpdateLoanInterestRates that fetches 
-- all loans and updates their interest rates based on the new policy.
-- Policy: 
-- 1. If LoanAmount > 15000, decrease the interest rate by 0.5% (premium customers incentive).
-- 2. If LoanAmount <= 15000, decrease the interest rate by 0.25%.

DECLARE
    -- Explicit cursor to select loans for update
    CURSOR c_loans IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans
        FOR UPDATE;
        
    v_old_rate NUMBER;
    v_new_rate NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- UPDATING LOAN INTEREST RATES BY POLICY ---');
    FOR rec IN c_loans LOOP
        v_old_rate := rec.InterestRate;
        
        -- Apply rate adjustment policy
        IF rec.LoanAmount > 15000 THEN
            v_new_rate := rec.InterestRate - 0.5;
        ELSE
            v_new_rate := rec.InterestRate - 0.25;
        END IF;

        -- Prevent interest rate from dropping below 0
        IF v_new_rate < 0 THEN
            v_new_rate := 0;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF c_loans;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || rec.LoanID || 
                             ' | Amount: $' || rec.LoanAmount || 
                             ' | Old Interest: ' || v_old_rate || '% ' ||
                             ' | New Interest: ' || v_new_rate || '%');
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rate updates successfully completed.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating loan interest rates: ' || SQLERRM);
END;
/
