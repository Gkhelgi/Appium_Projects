package PageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen {
	
	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
		public WebElement nameField;
		@AndroidFindBy(xpath=("//*[@text='Female']"))
		public WebElement checkBox;
		@AndroidFindBy(id="android:id/text1")
		public WebElement dropDowntextBox;
		//com.androidsample.generalstore:id/btnLetsShop
		@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
		public WebElement letsShopbtn;
		@AndroidFindBy(xpath="//*[@text='Argentina']")
		public WebElement countryName;
		@AndroidFindBy(xpath="//android.widget.Toast[1]")
		public WebElement toastMessage;
		
		
				
		
	}


