import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParameterizedTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 5, 10",
            "-2, 4, 2",
            "0, 0, 0",
            "-5, -5, -10"
    })
    public void testAdd(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculatorService.add(a, b));
    }
}
