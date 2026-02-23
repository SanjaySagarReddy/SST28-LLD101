import java.util.Map;

public class StudentDraft {
    private final Map<String, String> fields;

    public StudentDraft(Map<String, String> fields) {
        this.fields = fields;
    }

    public String name() {
        return fields.getOrDefault("name", "");
    }

    public String email() {
        return fields.getOrDefault("email", "");
    }

    public String phone() {
        return fields.getOrDefault("phone", "");
    }

    public String program() {
        return fields.getOrDefault("program", "");
    }
}