package com.example.reports;

public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport;   // cached real subject

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {

        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED -> user=" + user.getName()
                    + " report=" + reportId);
            return;
        }

        // lazy load
        if (realReport == null) {
            realReport = new RealReport(reportId, title, classification);
        }

        realReport.display(user);
    }
}