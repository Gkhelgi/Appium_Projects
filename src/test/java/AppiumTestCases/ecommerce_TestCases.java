package AppiumTestCases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.ExtentReporting;
import BaseClasses.ReusableMethods;
import BaseClasses.SetUp;
import PageObj.CheckOutPage;
import PageObj.HomeScreen;
import PageObj.ProductsPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class ecommerce_TestCases extends SetUp {
	

	
	@Test(priority=1)

	public void TC1() throws InterruptedException, IOException {
		
		
	
		AndroidDriver<AndroidElement> driver = AppSetUp("GeneralStoreApp");
		//AndroidDriver<AndroidElement> driver=setupReports();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		ExtentTest test=logger.createTest("TestCase1","Toast msg validations");
		
		HomeScreen hs = new HomeScreen(driver);
		ProductsPage pp = new ProductsPage(driver);
		
		test.log(Status.PASS, "User details enetred in the User name field ");
		hs.checkBox.click();
		hs.dropDowntextBox.click();
		ReusableMethods rm = new ReusableMethods(driver);
		rm.scrollText("Argentina");
		
		hs.countryName.click();
		
		hs.letsShopbtn.click();
		String toastmsg=hs.toastMessage.getAttribute("name");
		System.out.println(toastmsg);

		Assert.assertEquals("Please enter your name", toastmsg);//Actual validation
	}
	@Test(priority=2)

	public void TC2() throws InterruptedException, IOException {
		ExtentReporting ex=new ExtentReporting();
		ex.setupReports();
		ex.reportTearDown();
	
		AndroidDriver<AndroidElement> driver = AppSetUp("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExtentTest test=logger.createTest("TestCase2","Adding a product to the cart");
		
		HomeScreen hs = new HomeScreen(driver);
		ProductsPage pp = new ProductsPage(driver);
		hs.nameField.sendKeys("hello");
		test.log(Status.PASS, "User details enetred in the User name field ");
		hs.checkBox.click();
		hs.dropDowntextBox.click();
		ReusableMethods rm = new ReusableMethods(driver);
		rm.scrollText("Argentina");
		
		hs.countryName.click();
		
		hs.letsShopbtn.click();
		//driver.findElement(MobileBy.AndroidUIAutomator(
				//"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		// rm.scrollTextFully(pp.productList, "Jordan 6 Rings");
		/*int count = pp.products.size();
		for (int i = 1; i < count; i++) {
			String text = pp.products.get(i).getText();
			if (text.equalsIgnoreCase("Jordan 6 Rings")) {
				pp.addToCart.get(i).click();
				break;
			}

		}*/

		Thread.sleep(4000);
		pp.addToCart.get(0).click();

		pp.clickOnCart.click();
		test.log(Status.INFO, "One ietm added in the cart");
		
		
        
		// driver.quit();

	}
	@Test(priority=3)

	public void TC3() throws InterruptedException, IOException {
	
		AndroidDriver<AndroidElement> driver = AppSetUp("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExtentTest test=logger.createTest("TestCase3","Total amount validations");
		
		
		HomeScreen hs = new HomeScreen(driver);
		ProductsPage pp = new ProductsPage(driver);
		CheckOutPage cp=new CheckOutPage(driver);
		hs.nameField.sendKeys("hello");
		test.log(Status.PASS, "User details enetred in the User name field ");
		hs.checkBox.click();
		hs.dropDowntextBox.click();
		ReusableMethods rm = new ReusableMethods(driver);
		rm.scrollText("Argentina");
		
		hs.countryName.click();
		
		hs.letsShopbtn.click();
		pp.addToCart.get(0).click();
		rm.scrollText("Converse All Star");
		//int count = pp.products.size();
		//for (int i = 1; i < count; i++) {
		String text = pp.products.get(0).getText();
		if (text.equalsIgnoreCase("Converse All Star")) {
			pp.addToCart.get(0).click();
			
		}
		//}
		//pp.addToCart.get(0).click();
		pp.clickOnCart.click();
		Thread.sleep(4000);
		int count1=cp.productList.size();
		double sum=0;
		System.out.println(cp.productList.get(0));
		System.out.println(cp.productList.get(1));
		
		

		for(int j=0;j<count1;j++)

		{

		String amount1=cp.productList.get(j).getText();
		double amount=rm.getAmount(amount1);
		sum=sum+amount;
		}
		System.out.println(sum+"sum of products");
		String total=cp.totalAmt.getText();
		double totalVal=rm.getAmount(total);
		System.out.println(totalVal);
		Assert.assertEquals(sum, totalVal);
		
	

	}
	@Test(dependsOnMethods= {"TC2"})
	public void TC4() throws IOException
	{
		//AndroidDriver<AndroidElement> driver = AppSetUp("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExtentTest test=logger.createTest("TestCase4","Navigation to webView");
		
		TouchAction t=new TouchAction(driver);
		CheckOutPage cp=new CheckOutPage(driver);
		t.tap(tapOptions().withElement(element(cp.checkBox))).perform();
		t.longPress(longPressOptions().withElement(element(cp.termsText)).withDuration(ofSeconds(2))).release().perform();
	   cp.popUp.click();
	   cp.webView.click();
	}
	}
