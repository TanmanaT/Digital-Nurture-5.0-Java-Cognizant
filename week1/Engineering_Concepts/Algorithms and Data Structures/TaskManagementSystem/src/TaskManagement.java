public class TaskManagement {
    
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManagement() {
        this.head = null;
    }

    // Add task to the end: O(N) or O(1) if keeping a tail pointer.
    // Let's implement O(N) by traversing to ensure standard Singly Linked List traversal demonstration.
    public void add(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added Task: " + task);
    }

    // Search task: O(N) time complexity
    public Task search(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Traverse tasks: O(N) time complexity
    public void traverse() {
        System.out.println("--- Task List ---");
        if (head == null) {
            System.out.println("No tasks in the list.");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.task);
                temp = temp.next;
            }
        }
        System.out.println("-----------------");
    }

    // Delete task: O(N) time complexity
    public boolean delete(String taskId) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete task: " + taskId);
            return false;
        }

        // Handle deletion at the head
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            System.out.println("Deleted Task ID: " + taskId);
            return true;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.task.getTaskId().equals(taskId)) {
                prev.next = curr.next;
                System.out.println("Deleted Task ID: " + taskId);
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task with ID " + taskId + " not found for deletion.");
        return false;
    }
}
