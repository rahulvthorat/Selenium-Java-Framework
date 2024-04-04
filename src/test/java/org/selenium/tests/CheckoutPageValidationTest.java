package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.dataproviders.CheckoutDataProvider;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.CartPage;
import org.selenium.pages.CheckOutPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.LoginPage;
import org.selenium.pages.ProductPage;
import org.selenium.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageValidationTest extends BaseTest{

	
	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.SMOKE,
			CategoryType.BVT, CategoryType.REGRESSION })

	@Test(dataProvider = "checkoutData",dataProviderClass = CheckoutDataProvider.class)
	public void CheckOutValidation(String fName, String lName, String pCode) {
		LoginPage loginPage = new LoginPage(getDriver());

		String username = ConfigLoader.getInstance().getUsername();
		String password = ConfigLoader.getInstance().getPassword();

		HomePage homePage = loginPage
				.load()
				.enterUsername(username)
				.enterPassword(password)
				.clickOnLoginButton();
		
		Assert.assertTrue(homePage.isHeadingMsgDisplayed(), "Heading message is not displayed");
		Assert.assertTrue(homePage.isFooterMsgDisplayed(), "Footer message is not displayed");
		Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in");
		
		ProductPage productPage = new ProductPage(getDriver());
		CartPage cartPage =  productPage
	    .clickOnAddTOCart()
	    .clickOnCartIcon();
	    
	    Assert.assertTrue(cartPage.isProductDisplayed(), "Product is not displayed in the cart");
	    Assert.assertEquals(cartPage.getProductText(), "Sauce Labs Backpack", "Verification unsuccessful");
	    cartPage.clickOnCheckOut();
	    
	    CheckOutPage checkoutPage = new CheckOutPage(getDriver());
	    checkoutPage
	    .enterFirstName(fName)
	    .enterLastName(lName)
	    .enterPinCode(pCode);
	    
	    Assert.assertEquals(checkoutPage.getInfoText(), "Checkout: Your Information", "Verification unsuccessful");
	    
	}
	
}
