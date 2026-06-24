-- Exercise 2: Error Handling
-- Scenario 3: Ensure data integrity when adding a new customer.
-- Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. 
-- If a customer with the same ID already exists, handle the exception by logging an error and preventing the insertion.

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE,
    p_balance     IN NUMBER
) IS
    customer_exists EXCEPTION;
    PRAGMA EXCEPTION_INIT(customer_exists, -1); -- Map to primary key constraint violation (ORA-00001)
BEGIN
    -- Perform insertion
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE, 'FALSE');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_name || ' with ID ' || p_customer_id || ' added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: A customer with ID ' || p_customer_id || ' already exists in the system.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer insertion failed - ' || SQLERRM);
END AddNewCustomer;
/
