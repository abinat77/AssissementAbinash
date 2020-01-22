package TestCases;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.SearchResultPage;
import Pages.SignInPage;
import baseClasses.BaseTestPage;


public class TestCase001 extends BaseTestPage {

	
	@Test
	public void testSearchAndCompare() throws Exception {
		
		SignInPage objSigIn= new SignInPage();
		objSigIn.verifySignInPageDisplayed();   
		objSigIn.clickSignInButton();         
		     
		LoginPage Objlogin = new LoginPage();
		Objlogin.verifyLogInPageDisplayed();
		Objlogin.userLogIn(); //Calling login method

		HomePage ObjhomePage = new HomePage();
		ObjhomePage.verifyHomePageDisplayed();
		ObjhomePage.EnterKeywordAndSearchItem(); //Method to enter search keyword and search
		
		SearchResultPage ObjSearch = new SearchResultPage();
		ObjSearch.verifySearchResultPageDisplayed();
		String expectedItemName = ObjSearch.getItemName();

		ProductDetailsPage objProductDetailPage = new ProductDetailsPage();
		objProductDetailPage.verifyProductDetailsPageDisplayed();
		objProductDetailPage.clickBuyNowButton();
		
		/*CheckoutPage checkoutObj = new CheckoutPage();
		checkoutObj.verifyCheckOutPaymentsPageDisplayed();
		checkoutObj.clickNetBankingRadioButton();
		checkoutObj.selectBankName();
		checkoutObj.clickContinueButton(); */
		
		//String actualItemName = checkoutObj.getItemNameOnCheckOut();
	//	checkoutObj.compareItemNames(actualItemName, expectedItemName);	//Comparing the item name from product search and checkout page
	}
}
