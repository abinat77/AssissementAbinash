package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage {


	@FindBy(xpath = "//android.widget.Button[@text='Delete']")
	private WebElement deleteItem;
	
	@FindBy(xpath = "//*[@resource-id='buyNowCheckout']")
	private WebElement buttonBuyNow;


}
