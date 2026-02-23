/**
 * Rule: Student attendance must be >= 75%.
 */
public class AttendanceRule implements EligibilityRule {
    private final int minAttendancePct;

    public AttendanceRule(int minAttendancePct) {
        this.minAttendancePct = minAttendancePct;
    }

    public AttendanceRule() {
        this(75);
    }

    @Override
    public String evaluate(StudentProfile s) {
        if (s.attendancePct < minAttendancePct) {
            return "attendance below " + minAttendancePct;
        }
        return null;
    }
}
