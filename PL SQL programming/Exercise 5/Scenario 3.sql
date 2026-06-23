-- Exercise 5: Triggers
-- Scenario 3: Enforce business rules on deposits and withdrawals.
-- Question: Write a trigger CheckTransactionRules that ensures withdrawals do not exceed 
-- the balance and deposits are positive before inserting a record into the Transactions table.

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Check if the deposit amount is positive
    IF :new.TransactionType = 'Deposit' AND :new.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Deposit amount must be positive.');
    END IF;

    -- For withdrawals, verify that the amount is positive and does not exceed the account balance
    IF :new.TransactionType = 'Withdrawal' THEN
        IF :new.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20006, 'Withdrawal amount must be positive.');
        END IF;

        -- Fetch the account's current balance
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :new.AccountID;

        IF v_balance < :new.Amount THEN
            RAISE_APPLICATION_ERROR(-20007, 'Withdrawal amount ($' || :new.Amount || 
                                            ') exceeds current balance ($' || v_balance || 
                                            ') for Account ID ' || :new.AccountID);
        END IF;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20008, 'Account ID ' || :new.AccountID || ' not found.');
    WHEN OTHERS THEN
        -- Propagate our custom exceptions directly
        IF SQLCODE BETWEEN -20999 AND -20000 THEN
            RAISE;
        ELSE
            RAISE_APPLICATION_ERROR(-20009, 'Rule check failed: ' || SQLERRM);
        END IF;
END;
/
