public class PerformanceTester {
    public void performTask() {
        try {
            // Simulate task processing time
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
