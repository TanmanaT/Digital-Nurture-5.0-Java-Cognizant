import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Add product: O(1) time complexity
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists. Use updateProduct instead.");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Added: " + product);
        }
    }

    // Update product: O(1) time complexity
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated: " + product);
        } else {
            System.out.println("Product with ID " + productId + " not found for update.");
        }
    }

    // Delete product: O(1) time complexity
    public void deleteProduct(String productId) {
        Product removed = products.remove(productId);
        if (removed != null) {
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Product with ID " + productId + " not found for deletion.");
        }
    }

    // Get product: O(1) time complexity
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    // Display all products: O(N) time complexity
    public void displayInventory() {
        System.out.println("--- Current Inventory ---");
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : products.values()) {
                System.out.println(p);
            }
        }
        System.out.println("-------------------------");
    }
}
