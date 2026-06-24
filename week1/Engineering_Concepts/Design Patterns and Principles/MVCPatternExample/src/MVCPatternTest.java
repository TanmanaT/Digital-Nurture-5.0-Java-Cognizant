public class MVCPatternTest {
    public static void main(String[] args) {
        // Fetch student record from database/simulate mock creation
        Student studentModel = retrieveStudentFromDatabase();

        // Create view to display details
        StudentView studentView = new StudentView();

        // Create controller
        StudentController controller = new StudentController(studentModel, studentView);

        System.out.println("Displaying initial student state:");
        controller.updateView();

        // Update student data through controller
        System.out.println("\nUpdating student data...");
        controller.setStudentGrade("A+");
        controller.setStudentName("Johnathan Doe");

        System.out.println("\nDisplaying updated student state:");
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setId("CS101-042");
        student.setName("John Doe");
        student.setGrade("A");
        return student;
    }
}
