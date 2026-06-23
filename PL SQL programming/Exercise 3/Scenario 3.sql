-- Exercise 3: Stored Procedures
-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- Question: Write a stored procedure TransferFunds that transfers a specified amount from one account 
-- to another, checking that the source account has sufficient balance before making the transfer.

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) IS
    v_balance NUMBER;
    v_count   NUMBER;
BEGIN
    -- Check for positive amount
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
    END IF;

    -- Verify source account existence and get balance
    SELECT COUNT(*) INTO v_count FROM Accounts WHERE AccountID = p_from_account;
    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Source account ID ' || p_from_account || ' does not exist.');
    END IF;

    -- Verify destination account existence
    SELECT COUNT(*) INTO v_count FROM Accounts WHERE AccountID = p_to_account;
    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Destination account ID ' || p_to_account || ' does not exist.');
    END IF;

    -- Fetch and lock source balance
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;

    -- Verify sufficient funds
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20004, 'Insufficient funds. Available balance: $' || v_balance || 
                                        ', Requested amount: $' || p_amount);
    END IF;

    -- Execute transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    -- Record transactions
    DECLARE
        v_next_tx_id NUMBER;
    BEGIN
        SELECT NVL(MAX(TransactionID), 0) + 1 INTO v_next_tx_id FROM Transactions;
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (v_next_tx_id, p_from_account, SYSDATE, p_amount, 'Withdrawal');

        SELECT NVL(MAX(TransactionID), 0) + 1 INTO v_next_tx_id FROM Transactions;
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (v_next_tx_id, p_to_account, SYSDATE, p_amount, 'Deposit');
    END;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from account ' || 
                         p_from_account || ' to account ' || p_to_account);
END TransferFunds;
/
