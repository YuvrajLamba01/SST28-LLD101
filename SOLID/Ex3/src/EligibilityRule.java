import java.util.List;

/**
 * Abstraction for an eligibility rule.
 * Each rule checks a specific condition and provides a reason if failed.
 */
public interface EligibilityRule {
    /**
     * Evaluate if the student passes this rule.
     * @param s StudentProfile to check
     * @return null if passes, or a failure reason string if fails
     */
    String evaluate(StudentProfile s);
}
