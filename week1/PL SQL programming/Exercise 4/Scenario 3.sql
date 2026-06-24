-- Exercise 4: Functions
-- Scenario 3: Check if a customer has sufficient balance before making a transaction.
-- Question: Write a function HasSufficientBalance that takes an account ID and an amount as input 
-- and returns a boolean indicating whether the account has at least the specified amount.

CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    -- Validate amount
    IF p_amount < 0 THEN
        RETURN FALSE;
    END IF;

    -- Fetch current balance of account
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;

    -- Return check
    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        RETURN FALSE;
END HasSufficientBalance;
/
