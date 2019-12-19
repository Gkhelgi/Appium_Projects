package PageObj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {
	public ProductsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
		/*@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
		public WebElement productName;
		@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
		public WebElement addToCart;
		@AndroidFindBy(id="com.androidsample.generalstore:id/rvProductList")
		public WebElement productList;*/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	public List<WebElement> products;



	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> addToCart;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
		public WebElement clickOnCart;
		@AndroidFindBy(id = "com.androidsample.generalstore:id/rvProductList")
		public WebElement productList;
		


}
