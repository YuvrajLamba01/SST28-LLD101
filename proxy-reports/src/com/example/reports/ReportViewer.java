package com.example.reports;

import java.util.Objects;

/**
 * Viewer: now depends on Report interface (via proxy).
 */
public class ReportViewer {

    public void open(Report report, User user) {
        Objects.requireNonNull(report, "report");
        Objects.requireNonNull(user, "user");
        report.display(user);
    }
}
