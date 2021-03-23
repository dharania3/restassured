package utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener extends TestListenerAdapter  {
	public ExtentHtmlReporter htmlrep;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void onStart(ITestContext testcon) {
		System.out.println("1");
		htmlrep = new ExtentHtmlReporter("C:/Users/HP/eclipse-workspace/Restassuredtesting/reports/empreport.html");
		System.out.println("2");
		htmlrep.config().setReportName("TESTING REPORT");
		htmlrep.config().setDocumentTitle("EMPLOYEE REPORT");
		htmlrep.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlrep);
		extent.setSystemInfo("Hostname", "dummy api");
		extent.setSystemInfo("enviroment", "Test");
		extent.setSystemInfo("name", "dharani");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "PASSED CASE:"+result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "FAILED CASE:"+result.getName());
		test.log(Status.FAIL, "FAILED reson:"+result.getThrowable());
	}
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "SKIPPED CASE:"+result.getName());
	}
	
	public void onFinish(ITestContext tc) {
		extent.flush();
	}
}

		
		
		
