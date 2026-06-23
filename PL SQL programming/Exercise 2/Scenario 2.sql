-- Exercise 2: Error Handling
-- Scenario 2: Manage errors when updating employee salaries.
-- Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. 
-- If the employee ID does not exist, handle the exception and log an error message.

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id     IN NUMBER,
    p_percentage IN NUMBER
) IS
    v_current_salary NUMBER;
    employee_not_found EXCEPTION;
    invalid_percentage EXCEPTION;
BEGIN
    -- Check if percentage is valid
    IF p_percentage < -100 THEN
        RAISE invalid_percentage;
    END IF;

    -- Attempt to get employee salary to verify existence
    SELECT Salary INTO v_current_salary FROM Employees WHERE EmployeeID = p_emp_id FOR UPDATE;

    -- Update salary
    UPDATE Employees
    SET Salary = Salary * (1 + (p_percentage / 100))
    WHERE EmployeeID = p_emp_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully updated Salary for Employee ID ' || p_emp_id || 
                         '. New Salary: $' || (v_current_salary * (1 + (p_percentage / 100))));

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_emp_id || ' does not exist.');
    WHEN invalid_percentage THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Invalid percentage rate.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Unexpected error updating salary - ' || SQLERRM);
END UpdateSalary;
/
