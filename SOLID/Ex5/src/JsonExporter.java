import java.nio.charset.StandardCharsets;

/**
 * JSON exporter - honors the base contract consistently.
 * Handles null values the same way across all fields.
 */
public class JsonExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        // Consistent handling: if req is null, throw like other exporters
        if (req == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        String title = req.title == null ? "" : escape(req.title);
        String body = req.body == null ? "" : escape(req.body);
        
        String json = "{\"title\":\"" + title + "\",\"body\":\"" + body + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}
