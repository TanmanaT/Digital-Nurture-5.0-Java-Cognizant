public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        System.out.println("=== 1. Adding Products ===");
        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Headphones", 50, 79.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        inventory.displayInventory();

        System.out.println("\n=== 2. Updating Product ===");
        inventory.updateProduct("P002", 20, 479.99);
        inventory.displayInventory();

        System.out.println("\n=== 3. Deleting Product ===");
        inventory.deleteProduct("P003");
        inventory.displayInventory();

        System.out.println("\n=== 4. Edge Case: Duplicate Add & Missing Delete ===");
        inventory.addProduct(new Product("P001", "New Laptop", 5, 1200.00));
        inventory.deleteProduct("P999");
    }
}
