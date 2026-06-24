public class ForecastingTest {
    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial investment
        double growthRate = 0.05;     // 5% annual growth rate
        int periods = 10;             // 10 years

        System.out.println("=== Financial Forecasting ===");
        System.out.println("Present Value: $" + presentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Period: " + periods + " years");

        // 1. Recursive calculation
        double futureValueRecursive = Forecasting.calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("\nFuture Value (Recursive): $%.2f\n", futureValueRecursive);

        // 2. Iterative calculation
        double futureValueIterative = Forecasting.calculateFutureValueIterative(presentValue, growthRate, periods);
        System.out.printf("Future Value (Iterative): $%.2f\n", futureValueIterative);

        // Verify output matches the standard mathematical formula: PV * Math.pow(1 + r, n)
        double formulaValue = presentValue * Math.pow(1 + growthRate, periods);
        System.out.printf("Formula Verification [PV * (1+r)^n]: $%.2f\n", formulaValue);
    }
}
