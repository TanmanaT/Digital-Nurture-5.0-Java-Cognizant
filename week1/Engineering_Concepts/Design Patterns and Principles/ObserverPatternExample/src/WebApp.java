public class WebApp implements Observer {
    private final String webAppName;

    public WebApp(String webAppName) {
        this.webAppName = webAppName;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("[Web App - " + webAppName + "] Dashboard update: " + 
                           stockName + " price changed to $" + stockPrice);
    }
}
