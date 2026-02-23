import java.nio.charset.StandardCharsets;

/**
 * CSV exporter - honors the base contract: preserves all data.
 * Properly escapes fields to maintain data integrity.
 */
public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;
        
        // Properly quote and escape CSV fields to preserve data
        String csvTitle = escapeCsvField(title);
        String csvBody = escapeCsvField(body);
        String csv = "title,body\n" + csvTitle + "," + csvBody + "\n";
        
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String escapeCsvField(String field) {
        // If field contains comma, newline, or quote, wrap in quotes and escape quotes
        if (field.contains(",") || field.contains("\n") || field.contains("\"")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
}
