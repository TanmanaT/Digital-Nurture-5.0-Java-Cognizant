public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        System.out.println("--- Scenario 1: Credit Card Payment ---");
        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234-5678-9876-5432", "123", "12/28");
        context.setPaymentStrategy(creditCard);
        context.executePayment(450.75);

        // Pay using PayPal
        System.out.println("\n--- Scenario 2: PayPal Payment ---");
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");
        context.setPaymentStrategy(payPal);
        context.executePayment(99.99);
    }
}
