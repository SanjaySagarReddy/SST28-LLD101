import java.util.List;

public class ConsoleOnboardingPrinter implements OnboardingPrinter {
    @Override
    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    @Override
    public void printValidationErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String error : errors) {
            System.out.println("- " + error);
        }
    }

    @Override
    public void printStudentCreated(String studentId) {
        System.out.println("OK: created student " + studentId);
    }

    @Override
    public void printSaved(int totalStudents) {
        System.out.println("Saved. Total students: " + totalStudents);
    }

    @Override
    public void printConfirmation(StudentRecord record) {
        System.out.println("CONFIRMATION:");
        System.out.println(record);
    }
}