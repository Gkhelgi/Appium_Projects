package AppiumTestCases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;


import BaseClasses.SetUp;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.MultiTouchAction;

import org.openqa.selenium.interactions.touch.TouchActions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class CheckListApp_TestCases extends SetUp {

	@Test(priority=1)
	public void basicActionsTC1() throws IOException {
		
		AndroidDriver<AndroidElement> driver = AppSetUp("CheckList");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
		
		System.out.println("App launched");
		driver.findElement(By.id("jakiganicsystems.simplestchecklist:id/menu_add")).click();
		AndroidElement textBox = driver.findElement(By.id("jakiganicsystems.simplestchecklist:id/listrow_root"));
		textBox.click();
		// textBox.sendKeys("My first Checklist");

		// this.driver.findElement(By.id("jakiganicsystems.simplestchecklist:id/listrow_root")).setValue("My
		// first Checklist");
		Actions a = new Actions(driver);
		a.sendKeys("My first Checklist").perform();
	//	Assert.assertEquals("My first Checklist", textBox.getText());

		driver.findElement(By.id("jakiganicsystems.simplestchecklist:id/edit_add_back")).click();
		File screenshot = null;
		File screenshot1 = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1,
				new File("C:\\Users\\Megha\\Desktop\\Automation_Architect\\AppiumScreenshots\\checklistscreen.png"));
		System.out.println("Sreenshot taken");

	}
	@Test(priority=2)
	public void dragnDrop() throws IOException
	{
		AndroidDriver<AndroidElement> driver = AppSetUp("CheckList");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("App launched");
		AndroidElement source = driver.findElement(By.id("jakiganicsystems.simplestchecklist:id/listrow_dragger"));
		AndroidElement destination = driver.findElement(By.id("jakiganicsystems.simplestchecklist:id/menu_clear_completed"));
     TouchAction t = new TouchAction(driver);
     t.longPress(longPressOptions().withElement(element(source))
             .withDuration(ofSeconds(2))).moveTo(element(destination)).release().perform();
 }
		
     
		
	
	@Test(priority=3)
	//@Test(enabled=false)
	public void deleteCheckList() throws IOException
	{
		AndroidDriver<AndroidElement> driver = AppSetUp("CheckList");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("App launched");
		List<AndroidElement> checkBox=driver.findElements(By.id("jakiganicsystems.simplestchecklist:id/listrow_checkbox"));
		int count=checkBox.size();
		checkBox.get(2).click();
		checkBox.get(3).click();
		driver.findElement(By.id("jakiganicsystems.simplestchecklist:id/menu_clear_completed")).click();
		
		System.out.println("Two lists in the checkList are deleted");
		AndroidElement frame1=driver.findElement(By.id("jakiganicsystems.simplestchecklist:id/messageLeft"));
		System.out.println(frame1.getText());
		Assert.assertEquals("2 deleted", frame1.getText());
	
	}

}
