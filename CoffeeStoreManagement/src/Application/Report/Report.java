/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.Report;

import java.util.Date;


/**
 *
 * @author andymai
 */
public class Report {
    private String reportID;
    private Date dateReport;

    public Report(String reportID, Date dateReport) {
        this.reportID = reportID;
        this.dateReport = dateReport;
    }

    public Report() {
        this.reportID = null;
        this.dateReport = new Date();
    }
    
    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public Date getDateReport() {
        return dateReport;
    }

    public void setDateReport(Date dateReport) {
        this.dateReport = dateReport;
    }

    @Override
    public String toString() {
        return "Report{" + "reportID=" + reportID + ", dateReport=" + dateReport + '}';
    }

    
    
    
}
