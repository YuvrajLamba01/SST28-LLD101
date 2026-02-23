/**
 * Decorator: Adds size validation to an exporter.
 * This separates concerns: format encoding from delivery constraints.
 * The base exporter doesn't know about size limits; validation is external.
 */
public class SizeConstrainedExporter extends Exporter {
    private final Exporter delegate;
    private final int maxChars;

    public SizeConstrainedExporter(Exporter delegate, int maxChars) {
        this.delegate = delegate;
        this.maxChars = maxChars;
    }

    @Override
    public ExportResult export(ExportRequest req) {
        if (req != null && req.body != null && req.body.length() > maxChars) {
            throw new IllegalArgumentException(
                getFormatName() + " cannot handle content > " + maxChars + " chars"
            );
        }
        return delegate.export(req);
    }

    private String getFormatName() {
        if (delegate instanceof PdfExporter) return "PDF";
        if (delegate instanceof CsvExporter) return "CSV";
        if (delegate instanceof JsonExporter) return "JSON";
        return "Exporter";
    }
}
