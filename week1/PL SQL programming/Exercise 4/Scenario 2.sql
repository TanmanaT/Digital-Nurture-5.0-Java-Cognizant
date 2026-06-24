-- Exercise 4: Functions
-- Scenario 2: Compute the monthly installment for a loan.
-- Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate (annual), 
-- and loan duration in years as input and returns the monthly installment amount.

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount     IN NUMBER,
    p_interest_rate   IN NUMBER, -- Annual percentage interest rate (e.g., 5 for 5%)
    p_duration_years  IN NUMBER
) RETURN NUMBER IS
    v_monthly_installment NUMBER;
    v_monthly_rate        NUMBER;
    v_total_months        NUMBER;
BEGIN
    -- Validation of inputs
    IF p_loan_amount <= 0 OR p_duration_years <= 0 OR p_interest_rate < 0 THEN
        RETURN 0;
    END IF;

    v_total_months := p_duration_years * 12;

    -- If interest rate is zero, simple flat division
    IF p_interest_rate = 0 THEN
        v_monthly_installment := p_loan_amount / v_total_months;
    ELSE
        -- Monthly interest rate as a decimal (e.g., 5% annual is 5 / 12 / 100 = 0.0041667)
        v_monthly_rate := p_interest_rate / 12 / 100;
        
        -- Formula: M = P * (r * (1 + r)^n) / ((1 + r)^n - 1)
        v_monthly_installment := p_loan_amount * 
            (v_monthly_rate * POWER(1 + v_monthly_rate, v_total_months)) / 
            (POWER(1 + v_monthly_rate, v_total_months) - 1);
    END IF;

    RETURN ROUND(v_monthly_installment, 2);
END CalculateMonthlyInstallment;
/
