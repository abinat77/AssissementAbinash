package Pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import baseClasses.BaseTestPage;
import baseClasses.BaseTestPageFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BaseTestPage implements BaseTestPageFactory{
	
	@FindBy(xpath = "//*[@resource-id='icp-btn-close-announce']")
    private WebElement buttonCancelLanguageSelection;

	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/action_bar_home_logo\"]")
    private WebElement logoAmazon;
	
	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/rs_search_src_text\"]")
    private WebElement txtBoxSearch;
	
	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_query_builder\"]")
    private WebElement buttonAppendSearch;
	
	@FindBy(xpath = "//android.widget.TextView[@text='65-inch tv'])[2]")
    private WebElement productSelected;
	
	WebDriverWait wait=new WebDriverWait(driver, 20);

	
	public void waitForPageToLoad() {
		
		try {
		wait.until(ExpectedConditions.visibilityOf(buttonCancelLanguageSelection));
		buttonCancelLanguageSelection.click();
		System.out.print("Clicked on close language selection");
		} catch(Exception e) {
			Assert.fail("Failed to load Home Page");
		}
	}
	
	/**
	 * Verify Home page loaded
	 */
	public HomePage verifyHomePageDisplayed() {
		
		try {
			waitForPageToLoad();
			//TestReporter.AssertTrueWithScreenshot(txtBoxSearch.isDisplayed(),"Verify Home page is loaded");
		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load Home Page");
		}
		return this;
	}
	
	/**
	 * Enter the search keyword in search box and select value from auto suggestion
	 */
	
	public HomePage EnterKeywordAndSearchItem() {
		try {
		String searchItemName = getStringSearch();//Fetching search item name from TestData.xls
		//new TouchAction(driver).press(txtBoxSearch).release().perform();
		txtBoxSearch.click();
		txtBoxSearch.sendKeys(searchItemName);
		//TestReporter.logWithScreenShot("Searching... ");
		wait.until(ExpectedConditions.visibilityOf(productSelected));
		productSelected.click(); //Selecting product from auto suggestion
		//TestReporter.logWithScreenShot("Search Result ");
		} catch (Exception e) {
			Assert.fail("Search process failed");
		}
		return this;
	}

	@Override
	public void reInitialze() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
}
