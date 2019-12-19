package BaseClasses;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ReusableMethods {
	AndroidDriver<AndroidElement> driver;
	public ReusableMethods(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}
	
	public void scrollText(String text) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\"))"));
	}
	public void scrollTextFully(WebElement productList,String child)
	{
		  driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"" + productList + "\")).scrollIntoView(new UiSelector().textMatches(\"" + child + "\").instance(0))"));

		     
	}
	public  double getAmount(String value)

	{

	value= value.substring(1);

	double amount2value=Double.parseDouble(value);

	return amount2value;

	}
	

}
