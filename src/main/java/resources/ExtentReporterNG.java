package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
	// ExtentReports , ExtentSparkReporter
	String path =System.getProperty("user.dir")+"\\reports\\index.html"; //path to save the report
	ExtentSparkReporter reporter = new ExtentSparkReporter(path); // class used to create the report
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	extent =new ExtentReports(); // object created for Extentreports class and used to generate an HTML report on the user-specified path
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Naga");
	
	return extent;
	}


}
