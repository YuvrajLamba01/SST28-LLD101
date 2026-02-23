/**
 * Rule: Student CGR must be >= 8.0.
 */
public class CgrRule implements EligibilityRule {
    private final double minCgr;

    public CgrRule(double minCgr) {
        this.minCgr = minCgr;
    }

    public CgrRule() {
        this(8.0);
    }

    @Override
    public String evaluate(StudentProfile s) {
        if (s.cgr < minCgr) {
            return "CGR below " + minCgr;
        }
        return null;
    }
}
