public abstract class Exporter {
    // Contract: export always returns an ExportResult, never throws.

    public abstract ExportResult export(ExportRequest req);
}