public class MobileApp implements Observer {
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("[Mobile App - " + appName + "] Notification: " + 
                           stockName + " is now trading at $" + stockPrice);
    }
}
