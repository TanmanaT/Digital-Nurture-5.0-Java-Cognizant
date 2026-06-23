-- Exercise 3: Stored Procedures
-- Scenario 2: Implement a bonus scheme for employees based on their performance.
-- Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees 
-- in a given department by adding a bonus percentage passed as a parameter.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department      IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
    invalid_bonus EXCEPTION;
BEGIN
    -- Validate bonus percentage
    IF p_bonus_percentage < 0 THEN
        RAISE invalid_bonus;
    END IF;

    -- Update salaries of employees in the specified department
    UPDATE Employees
    SET Salary = Salary * (1 + (p_bonus_percentage / 100))
    WHERE Department = p_department;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Successfully applied bonus of ' || p_bonus_percentage || 
                             '% to ' || SQL%ROWCOUNT || ' employee(s) in department: ' || p_department);
    END IF;

    COMMIT;
EXCEPTION
    WHEN invalid_bonus THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Bonus percentage cannot be negative.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
END UpdateEmployeeBonus;
/
