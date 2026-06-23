public class EmployeeTest {
    public static void main(String[] args) {
        // Create management system with capacity of 4
        EmployeeManagement directory = new EmployeeManagement(4);

        System.out.println("=== 1. Adding Employees ===");
        directory.add(new Employee("E001", "John Doe", "Software Engineer", 85000));
        directory.add(new Employee("E002", "Jane Smith", "Product Manager", 95000));
        directory.add(new Employee("E003", "Bob Johnson", "QA Analyst", 70000));
        directory.add(new Employee("E004", "Alice Brown", "UX Designer", 80000));

        // Test capacity limit
        System.out.println("\n--- Testing capacity overflow ---");
        directory.add(new Employee("E005", "Charlie Green", "HR Specialist", 65000));

        System.out.println("\n=== 2. Traversing Employees ===");
        directory.traverse();

        System.out.println("\n=== 3. Searching for Employee E002 ===");
        Employee found = directory.search("E002");
        System.out.println("Search Result: " + found);

        System.out.println("\n=== 4. Deleting Employee E003 ===");
        directory.delete("E003");
        directory.traverse();

        System.out.println("\n=== 5. Edge Case: Searching deleted employee ===");
        System.out.println("Search Result for E003: " + directory.search("E003"));
    }
}
