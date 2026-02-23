/**
 * Rule: Student must not have a disciplinary flag.
 */
public class DisciplinaryFlagRule implements EligibilityRule {
    @Override
    public String evaluate(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return "disciplinary flag present";
        }
        return null;
    }
}
