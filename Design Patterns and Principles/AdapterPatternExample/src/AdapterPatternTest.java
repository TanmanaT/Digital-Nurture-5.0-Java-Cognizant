public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create Paypal adaptee and its adapter
        PaypalGateway paypalGateway = new PaypalGateway();
        PaymentProcessor paypalProcessor = new PaypalAdapter(paypalGateway);

        // Create Stripe adaptee and its adapter
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        // Test payments
        System.out.println("Testing PayPal Integration:");
        paypalProcessor.processPayment(150.0);

        System.out.println("\nTesting Stripe Integration:");
        stripeProcessor.processPayment(250.50);
    }
}
