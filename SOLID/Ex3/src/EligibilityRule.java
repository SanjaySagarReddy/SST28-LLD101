public interface EligibilityRule {
    // Returns null if the student passes this rule.
    // Returns a reason string if the student fails.
    String check(StudentProfile student);
}