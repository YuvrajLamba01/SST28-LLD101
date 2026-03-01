public class CodeGrader implements SubmissionGrader {
    private final Rubric rubric;

    public CodeGrader(Rubric rubric) {
        this.rubric = rubric;
    }

    public int grade(Submission s) {
        // fake scoring (deterministic)
        int base = 50;
        return base + rubric.bonus;
    }
}
