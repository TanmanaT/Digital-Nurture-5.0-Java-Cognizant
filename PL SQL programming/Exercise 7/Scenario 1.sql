-- Exercise 7: Packages
-- Scenario 1: Group all customer-related procedures and functions into a package.
-- Question: Create a package CustomerManagement with procedures for adding a new customer, 
-- updating customer details, and a function to get customer balance.

CREATE OR REPLACE PACKAGE CustomerManagement AS
    -- Procedure to add a new customer
    PROCEDURE AddNewCustomer (
        p_customer_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_dob         IN DATE,
        p_balance     IN NUMBER
    );

    -- Procedure to update customer details
    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_dob         IN DATE
    );

    -- Function to retrieve the current customer balance
    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    -- Procedure implementation: Add a new customer
    PROCEDURE AddNewCustomer (
        p_customer_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_dob         IN DATE,
        p_balance     IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE, 'FALSE');
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Package CustomerManagement: Customer ' || p_name || ' added successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package CustomerManagement Error: Customer ID ' || p_customer_id || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package CustomerManagement Error: ' || SQLERRM);
    END AddNewCustomer;

    -- Procedure implementation: Update customer details
    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_dob         IN DATE
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            DOB = p_dob,
            LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Package CustomerManagement: No customer found with ID ' || p_customer_id);
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Package CustomerManagement: Details for Customer ID ' || p_customer_id || ' updated successfully.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package CustomerManagement Error updating details: ' || SQLERRM);
    END UpdateCustomerDetails;

    -- Function implementation: Get customer balance
    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER := 0;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_customer_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Package CustomerManagement: Customer ID ' || p_customer_id || ' not found.');
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Package CustomerManagement Error: ' || SQLERRM);
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/
