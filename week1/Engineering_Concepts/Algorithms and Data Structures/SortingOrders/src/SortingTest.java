public class SortingTest {
    public static void main(String[] args) {
        Order[] bubbleSortOrders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 120.00),
            new Order("O003", "Charlie", 450.00),
            new Order("O004", "David", 80.75),
            new Order("O005", "Emma", 310.20)
        };

        Order[] quickSortOrders = bubbleSortOrders.clone();

        System.out.println("=== Original Orders ===");
        printOrders(bubbleSortOrders);

        System.out.println("\n=== 1. Bubble Sort (Sorting by Total Price) ===");
        SortingAlgorithms.bubbleSort(bubbleSortOrders);
        printOrders(bubbleSortOrders);

        System.out.println("\n=== 2. Quick Sort (Sorting by Total Price) ===");
        SortingAlgorithms.quickSort(quickSortOrders, 0, quickSortOrders.length - 1);
        printOrders(quickSortOrders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
