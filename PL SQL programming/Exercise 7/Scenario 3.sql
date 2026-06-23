-- Exercise 7: Packages
-- Scenario 3: Group all account-related operations into a package.
-- Question: Create a package AccountOperations with procedures for opening a new account, 
-- closing an account, and a function to get the total balance of a customer across all accounts.

CREATE OR REPLACE PACKAGE AccountOperations AS
    -- Procedure to open a new account
    PROCEDURE OpenAccount (
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_initial_bal  IN NUMBER
    );

    -- Procedure to close an account
    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    );

    -- Function to get total balance of a customer across all accounts
    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    -- Procedure implementation: Open a new account
    PROCEDURE OpenAccount (
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_initial_bal  IN NUMBER
    ) IS
        v_cust_exists NUMBER;
    BEGIN
        -- Check if customer exists
        SELECT COUNT(*) INTO v_cust_exists FROM Customers WHERE CustomerID = p_customer_id;
        IF v_cust_exists = 0 THEN
            RAISE_APPLICATION_ERROR(-20101, 'Customer with ID ' || p_customer_id || ' does not exist.');
        END IF;

        -- Create Account
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_initial_bal, SYSDATE);
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Package AccountOperations: Account ID ' || p_account_id || 
                             ' successfully opened for Customer ID ' || p_customer_id);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package AccountOperations Error: Account ID ' || p_account_id || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package AccountOperations Error: ' || SQLERRM);
    END OpenAccount;

    -- Procedure implementation: Close an account
    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    ) IS
        v_count NUMBER;
    BEGIN
        SELECT COUNT(*) INTO v_count FROM Accounts WHERE AccountID = p_account_id;
        IF v_count = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Package AccountOperations: Account ID ' || p_account_id || ' does not exist.');
            RETURN;
        END IF;

        -- Delete account
        DELETE FROM Accounts WHERE AccountID = p_account_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Package AccountOperations: Account ID ' || p_account_id || ' closed successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package AccountOperations Error closing account: ' || SQLERRM);
    END CloseAccount;

    -- Function implementation: Get total balance across all accounts
    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_total_balance NUMBER := 0;
        v_cust_exists   NUMBER;
    BEGIN
        -- Check if customer exists
        SELECT COUNT(*) INTO v_cust_exists FROM Customers WHERE CustomerID = p_customer_id;
        IF v_cust_exists = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Package AccountOperations: Customer ID ' || p_customer_id || ' not found.');
            RETURN NULL;
        END IF;

        -- Sum balances
        SELECT SUM(Balance) INTO v_total_balance 
        FROM Accounts 
        WHERE CustomerID = p_customer_id;

        -- Handle case where customer exists but has no accounts
        RETURN NVL(v_total_balance, 0);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Package AccountOperations Error calculating total balance: ' || SQLERRM);
            RETURN NULL;
    END GetTotalBalance;

END AccountOperations;
/
