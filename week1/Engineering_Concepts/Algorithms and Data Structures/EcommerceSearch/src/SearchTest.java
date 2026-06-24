import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P103", "Wireless Mouse", "Electronics"),
            new Product("P105", "Mechanical Keyboard", "Electronics"),
            new Product("P101", "Gaming Monitor", "Electronics"),
            new Product("P104", "USB-C Hub", "Accessories"),
            new Product("P102", "Noise Cancelling Headphones", "Audio")
        };

        String targetId = "P104";

        System.out.println("=== 1. Linear Search ===");
        System.out.println("Searching for ID: " + targetId);
        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
        System.out.println("Found: " + resultLinear);

        System.out.println("\n=== 2. Sorting products by ID for Binary Search ===");
        // Sort products by productId to satisfy binary search prerequisite
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\n=== 3. Binary Search ===");
        System.out.println("Searching for ID: " + targetId);
        Product resultBinary = SearchAlgorithms.binarySearch(products, targetId);
        System.out.println("Found: " + resultBinary);

        System.out.println("\n=== 4. Test Missing Product ===");
        String missingId = "P999";
        System.out.println("Linear Search result for P999: " + SearchAlgorithms.linearSearch(products, missingId));
        System.out.println("Binary Search result for P999: " + SearchAlgorithms.binarySearch(products, missingId));
    }
}
