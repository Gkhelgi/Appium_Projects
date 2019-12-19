package BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SetUp extends ExtentReporting{
	public static AndroidDriver<AndroidElement> driver;
	public static Properties prop;
	
	
	public AndroidDriver<AndroidElement> AppSetUp(String appName) throws IOException
	{	
		
	//	String path = "C:\\Users\\Megha\\Desktop\\Automation_Architect\\Appium\\Reports\\NativeApps.html";
			
		//reports = new ExtentReports(path);
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\BaseClasses\\AppData.properties");
		prop.load(fis);
		String device1= prop.getProperty("Device");
		String udid1= prop.getProperty("udid");	
		//String appPackage=prop.getProperty("app_Package");
		//String appActivity=prop.getProperty("app_activity");
		String generalStore=prop.getProperty(appName);	
		File f=new File("src\\main\\java");
		File app=new File(f,generalStore);
		DesiredCapabilities cap=new DesiredCapabilities();
	     cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.UDID, udid1);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, device1);
			cap.setCapability(MobileCapabilityType.VERSION, "8");
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
	    cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   
	   return driver;
	}
		
	}


