package BaseClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporting {
	public static ExtentHtmlReporter htmlReports;
	public static ExtentReports logger;
	
	@BeforeTest
	public void setupReports()
	{
		htmlReports=new ExtentHtmlReporter("Extent.html");
		logger=new ExtentReports();
		logger.attachReporter(htmlReports);
	}
	@AfterTest
	public void reportTearDown()
	{
		logger.flush();
	}

}
