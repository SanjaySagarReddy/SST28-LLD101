import java.util.LinkedHashMap;
import java.util.Map;

public class StudentInputParser {
    public StudentDraft parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();
        String[] parts = raw.split(";");
        for (String part : parts) {
            String[] tokens = part.split("=", 2);
            if (tokens.length == 2) {
                kv.put(tokens[0].trim(), tokens[1].trim());
            }
        }
        return new StudentDraft(kv);
    }
}