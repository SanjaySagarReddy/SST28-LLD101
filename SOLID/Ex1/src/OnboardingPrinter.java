import java.util.List;

public interface OnboardingPrinter {
    void printInput(String raw);
    void printValidationErrors(List<String> errors);
    void printStudentCreated(String studentId);
    void printSaved(int totalStudents);
    void printConfirmation(StudentRecord record);
}