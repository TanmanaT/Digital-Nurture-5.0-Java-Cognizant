public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Base notifier: Email only
        Notifier emailNotifier = new EmailNotifier();
        System.out.println("--- Scenario 1: Base Email Notifier ---");
        emailNotifier.send("Hello, this is a test notification!");

        System.out.println("\n--- Scenario 2: Email + SMS Notifier ---");
        // Decorate email notifier with SMS
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        smsNotifier.send("System updated successfully!");

        System.out.println("\n--- Scenario 3: Email + SMS + Slack Notifier ---");
        // Decorate SMS notifier with Slack
        Notifier slackAndSmsNotifier = new SlackNotifierDecorator(smsNotifier);
        slackAndSmsNotifier.send("Critical alert: High CPU usage!");
    }
}
