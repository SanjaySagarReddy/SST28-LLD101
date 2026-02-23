public class OnboardingService {
    private final StudentStore store;
    private final StudentInputParser parser;
    private final StudentValidator validator;
    private final OnboardingPrinter printer;

    public OnboardingService(
            StudentStore store,
            StudentInputParser parser,
            StudentValidator validator,
            OnboardingPrinter printer
    ) {
        this.store = store;
        this.parser = parser;
        this.validator = validator;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        StudentDraft draft = parser.parse(raw);
        ValidationResult validation = validator.validate(draft);
        if (!validation.isValid()) {
            printer.printValidationErrors(validation.errors());
            return;
        }

        String id = IdUtil.nextStudentId(store.count());
        StudentRecord record = new StudentRecord(id, draft.name(), draft.email(), draft.phone(), draft.program());
        store.save(record);

        printer.printStudentCreated(id);
        printer.printSaved(store.count());
        printer.printConfirmation(record);
    }
}