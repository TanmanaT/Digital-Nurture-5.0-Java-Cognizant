public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("TradeTracker");
        Observer mobileApp2 = new MobileApp("Investo");
        Observer webDashboard = new WebApp("GlobalMarkets");

        // Register observers
        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webDashboard);

        System.out.println("--- Scenario 1: Initial Price Update ---");
        stockMarket.setStockData("AAPL (Apple Inc.)", 175.50);

        System.out.println("\n--- Scenario 2: Deregistering an Observer ---");
        stockMarket.deregisterObserver(mobileApp2);
        stockMarket.setStockData("GOOGL (Alphabet Inc.)", 142.20);
    }
}
