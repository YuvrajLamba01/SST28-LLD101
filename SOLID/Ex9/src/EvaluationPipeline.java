public class EvaluationPipeline {
    private final SubmissionChecker checker;
    private final SubmissionGrader grader;
    private final EvaluationReportWriter writer;

    public EvaluationPipeline(SubmissionChecker checker, SubmissionGrader grader, EvaluationReportWriter writer) {
        this.checker = checker;
        this.grader = grader;
        this.writer = writer;
    }

    public void evaluate(Submission sub) {
        int plag = checker.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
