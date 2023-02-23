package reports;
import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

static ExtentReports reports;
static ExtentTest test;
static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static ExtentReports getReports() {
		if(reports == null) {
			reports = new ExtentReports();
			// init the report folder
			Date d = new Date();
			
			System.out.println(d.toString().replaceAll(":", "-"));
			String reportFolderPath = System.getProperty("user.dir") +"//reports//"+d.toString().replaceAll(":", "-");
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolderPath);
			reports.setSystemInfo("Environment", "Testing");
			reports.setSystemInfo("Tester Name", "Dasari");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setReportName("Tests Report");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setEncoding("utf-8");
			
			reports.attachReporter(sparkReporter);
		}
		
		return reports;

	}
	
	public static synchronized ExtentTest getTest(String browser) {
		
		 ExtentTest test = extentTest.get();
	        if (test == null) {
	            test = ExtentManager.getReports().createTest(browser);
	            extentTest.set(test);
	        }
	        return test;
	    }
		
}


