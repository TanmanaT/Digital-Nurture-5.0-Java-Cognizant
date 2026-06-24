public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    // Add employee: O(1) time complexity (if space available)
    public boolean add(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Cannot add employee. Array capacity full!");
            return false;
        }
        employees[size] = employee;
        size++;
        System.out.println("Added Employee: " + employee);
        return true;
    }

    // Search employee: O(N) time complexity
    public Employee search(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse employees: O(N) time complexity
    public void traverse() {
        System.out.println("--- Employee Directory ---");
        if (size == 0) {
            System.out.println("No employee records found.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("--------------------------");
    }

    // Delete employee: O(N) time complexity (due to shifting elements)
    public boolean delete(String employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee with ID " + employeeId + " not found for deletion.");
            return false;
        }

        // Shift elements to the left to fill the gap
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null; // Clear last element reference
        size--;
        System.out.println("Deleted employee with ID: " + employeeId);
        return true;
    }
}
