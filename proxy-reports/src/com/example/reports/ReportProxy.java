package com.example.reports;

import java.util.Objects;

/**
 * Proxy: handles access control and lazy loading.
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport; // lazy-loaded and cached

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = Objects.requireNonNull(reportId, "reportId");
        this.title = Objects.requireNonNull(title, "title");
        this.classification = Objects.requireNonNull(classification, "classification");
    }

    @Override
    public void display(User user) {
        Objects.requireNonNull(user, "user");
        
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("[ACCESS DENIED] User " + user.getName() 
                    + " cannot access " + classification + " report " + reportId);
            return;
        }
        
        // Lazy load the real report only if needed
        if (realReport == null) {
            System.out.println("[proxy] creating RealReport for " + reportId);
            realReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[proxy] reusing cached RealReport for " + reportId);
        }
        
        realReport.display(user);
    }
}
