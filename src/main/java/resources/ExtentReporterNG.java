package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNG {

    public static ExtentReports extent;

    public static ExtentReports getReporterObj(){
        String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
        reporter.config().setReportName("E2E Project Report");
        reporter.config().setDocumentTitle("E2E Project Test Results Document");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Author", "Rahul Dhiman");
        return extent;
    }
}
