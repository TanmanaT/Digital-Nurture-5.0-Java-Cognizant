-- Exercise 2: Error Handling
-- Scenario 1: Handle exceptions during fund transfers between accounts.
-- Question: Write a stored procedure SafeTransferFunds that transfers funds between two accounts. 
-- Ensure that if any error occurs (e.g., insufficient funds), an appropriate error message is logged and the transaction is rolled back.

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) IS
    v_from_balance NUMBER;
    v_to_balance   NUMBER;
    insufficient_funds EXCEPTION;
    invalid_amount EXCEPTION;
    account_not_found EXCEPTION;
    v_count NUMBER;
BEGIN
    -- Check if amount is positive
    IF p_amount <= 0 THEN
        RAISE invalid_amount;
    END IF;

    -- Check if both accounts exist
    SELECT COUNT(*) INTO v_count FROM Accounts WHERE AccountID = p_from_account;
    IF v_count = 0 THEN
        RAISE account_not_found;
    END IF;

    SELECT COUNT(*) INTO v_count FROM Accounts WHERE AccountID = p_to_account;
    IF v_count = 0 THEN
        RAISE account_not_found;
    END IF;

    -- Fetch current balance of source account
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;

    -- Check for sufficient balance
    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Perform Transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    -- Record Transactions
    -- Assuming a new transaction ID is generated or queried (using MAX(ID)+1 for simplicity in standard SQL scripts)
    -- We can use a sequence or MAX + 1. Since we don't have a sequence in schema, we will select MAX(TransactionID) + 1.
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
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account);

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Insufficient funds in Account ' || p_from_account);
    WHEN invalid_amount THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Transfer amount must be greater than zero.');
    WHEN account_not_found THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: One or both accounts do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Unexpected error - ' || SQLERRM);
END SafeTransferFunds;
/
