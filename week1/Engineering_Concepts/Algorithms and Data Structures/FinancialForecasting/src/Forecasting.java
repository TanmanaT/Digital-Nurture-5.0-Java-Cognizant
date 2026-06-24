public class Forecasting {

    // Recursive implementation to calculate future value: O(N) time complexity
    // Formula: Future Value = Present Value * (1 + growthRate)^periods
    // Recursion base case: periods == 0 -> return presentValue
    // Recursion step: calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1)
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case
        if (periods == 0) {
            return presentValue;
        }
        // Recursive step
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    // Optimized Iterative Implementation to avoid StackOverflowError for large periods: O(N) time, O(1) space
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }
}
