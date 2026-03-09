package com.example.reports;

/**
 * Demo with Proxy pattern:
 * - Unauthorized access is blocked
 * - Disk load happens lazily via proxy
 * - Repeated views reuse cached RealReport
 */
public class App {

    public static void main(String[] args) {
        User student = new User("Jasleen", "STUDENT");
        User faculty = new User("Prof. Noor", "FACULTY");
        User admin = new User("Kshitij", "ADMIN");

        Report publicReport = new ReportProxy("R-101", "Orientation Plan", "PUBLIC");
        Report facultyReport = new ReportProxy("R-202", "Midterm Review", "FACULTY");
        Report adminReport = new ReportProxy("R-303", "Budget Audit", "ADMIN");

        ReportViewer viewer = new ReportViewer();

        System.out.println("=== CampusVault Demo ===");

        viewer.open(publicReport, student);
        System.out.println();

        viewer.open(facultyReport, student);
        System.out.println();

        viewer.open(facultyReport, faculty);
        System.out.println();

        viewer.open(adminReport, admin);
        System.out.println();

        viewer.open(adminReport, admin);
    }
}
