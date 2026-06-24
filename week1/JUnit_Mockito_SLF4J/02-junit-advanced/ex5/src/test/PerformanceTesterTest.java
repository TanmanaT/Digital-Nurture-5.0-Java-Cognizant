import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTesterTest {
    private final PerformanceTester tester = new PerformanceTester();

    @Test
    public void testPerformanceTimeout() {
        // Verify that the task completes within 500 milliseconds
        assertTimeout(Duration.ofMillis(500), () -> {
            tester.performTask();
        });
    }
}
