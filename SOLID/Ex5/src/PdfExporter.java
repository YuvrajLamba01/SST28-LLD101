import java.nio.charset.StandardCharsets;

/**
 * PDF exporter - honors the base contract: accepts any content.
 * Encodes to a simple PDF-like format.
 */
public class PdfExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;
        
        // Encode as simple PDF format without arbitrary size restrictions
        String fakePdf = "PDF(" + title + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
