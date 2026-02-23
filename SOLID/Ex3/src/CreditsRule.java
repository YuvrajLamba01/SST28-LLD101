/**
 * Rule: Student earned credits must be >= 20.
 */
public class CreditsRule implements EligibilityRule {
    private final int minCredits;

    public CreditsRule(int minCredits) {
        this.minCredits = minCredits;
    }

    public CreditsRule() {
        this(20);
    }

    @Override
    public String evaluate(StudentProfile s) {
        if (s.earnedCredits < minCredits) {
            return "credits below " + minCredits;
        }
        return null;
    }
}
