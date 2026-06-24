-- Exercise 4: Functions
-- Scenario 1: Calculate the age of customers for eligibility checks.
-- Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years.

CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    -- Check if DOB is in the future
    IF p_dob > SYSDATE THEN
        RETURN 0;
    END IF;

    -- Calculate age in years based on months between DOB and SYSDATE
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    
    RETURN v_age;
END CalculateAge;
/
