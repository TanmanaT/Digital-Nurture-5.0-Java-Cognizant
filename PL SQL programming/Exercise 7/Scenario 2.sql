-- Exercise 7: Packages
-- Scenario 2: Create a package to manage employee data.
-- Question: Write a package EmployeeManagement with procedures to hire new employees, 
-- update employee details, and a function to calculate annual salary.

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    -- Procedure to hire a new employee
    PROCEDURE HireNewEmployee (
        p_employee_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2,
        p_hire_date   IN DATE
    );

    -- Procedure to update employee details
    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2
    );

    -- Function to calculate annual salary (Salary * 12)
    FUNCTION CalculateAnnualSalary (
        p_employee_id IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    -- Procedure implementation: Hire new employee
    PROCEDURE HireNewEmployee (
        p_employee_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2,
        p_hire_date   IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, p_hire_date);
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Package EmployeeManagement: Employee ' || p_name || ' hired successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package EmployeeManagement Error: Employee ID ' || p_employee_id || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package EmployeeManagement Error: ' || SQLERRM);
    END HireNewEmployee;

    -- Procedure implementation: Update employee details
    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Position = p_position,
            Salary = p_salary,
            Department = p_department
        WHERE EmployeeID = p_employee_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Package EmployeeManagement: No employee found with ID ' || p_employee_id);
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Package EmployeeManagement: Details for Employee ID ' || p_employee_id || ' updated successfully.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Package EmployeeManagement Error updating details: ' || SQLERRM);
    END UpdateEmployeeDetails;

    -- Function implementation: Calculate annual salary
    FUNCTION CalculateAnnualSalary (
        p_employee_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER := 0;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_employee_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Package EmployeeManagement: Employee ID ' || p_employee_id || ' not found.');
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Package EmployeeManagement Error: ' || SQLERRM);
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;
/
