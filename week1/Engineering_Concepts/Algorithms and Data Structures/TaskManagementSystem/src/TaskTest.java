public class TaskTest {
    public static void main(String[] args) {
        TaskManagement taskList = new TaskManagement();

        System.out.println("=== 1. Adding Tasks ===");
        taskList.add(new Task("T001", "Design Database Schema", "Done"));
        taskList.add(new Task("T002", "Implement REST API", "In Progress"));
        taskList.add(new Task("T003", "Write Unit Tests", "Pending"));
        taskList.add(new Task("T004", "Deploy to Staging", "Pending"));

        System.out.println("\n=== 2. Traversing Tasks ===");
        taskList.traverse();

        System.out.println("\n=== 3. Searching for Task T002 ===");
        Task found = taskList.search("T002");
        System.out.println("Search Result: " + found);

        System.out.println("\n=== 4. Deleting Task T001 (Head) ===");
        taskList.delete("T001");
        taskList.traverse();

        System.out.println("\n=== 5. Deleting Task T003 (Middle) ===");
        taskList.delete("T003");
        taskList.traverse();

        System.out.println("\n=== 6. Edge Case: Searching deleted task ===");
        System.out.println("Search Result for T001: " + taskList.search("T001"));
    }
}
