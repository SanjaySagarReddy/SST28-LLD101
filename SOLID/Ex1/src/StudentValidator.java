import java.util.ArrayList;
import java.util.List;

public class StudentValidator {
    public ValidationResult validate(StudentDraft draft) {
        List<String> errors = new ArrayList<>();

        if (draft.name().isBlank()) {
            errors.add("name is required");
        }

        if (draft.email().isBlank() || !draft.email().contains("@")) {
            errors.add("email is invalid");
        }

        if (draft.phone().isBlank() || !draft.phone().chars().allMatch(Character::isDigit)) {
            errors.add("phone is invalid");
        }

        if (!(draft.program().equals("CSE") || draft.program().equals("AI") || draft.program().equals("SWE"))) {
            errors.add("program is invalid");
        }

        return new ValidationResult(errors);
    }
}