/**
 * Exporter: Contract for converting ExportRequest to bytes in a specific format.
 * 
 * CONTRACT:
 * - Precondition: req is a valid ExportRequest (title and body can be any string, including null)
 * - Postcondition: returns a non-null ExportResult with valid content type and bytes
 * - Behavior: Must not throw exceptions for valid input; must handle null gracefully
 * - Substitutability: Any subclass must accept the same preconditions as the base class
 */
public abstract class Exporter {
    /**
     * Export request to bytes in a specific format.
     * @param req non-null ExportRequest
     * @return non-null ExportResult containing formatted content
     * @throws IllegalArgumentException only if req is null
     */
    public abstract ExportResult export(ExportRequest req);
}
