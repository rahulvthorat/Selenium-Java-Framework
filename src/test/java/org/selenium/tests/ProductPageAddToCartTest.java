package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.CartPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.LoginPage;
import org.selenium.pages.ProductPage;
import org.selenium.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageAddToCartTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.SMOKE,
			CategoryType.BVT, CategoryType.REGRESSION })

	@Test
	public void AddToCartValidation() {
		LoginPage loginPage = new LoginPage(getDriver());

		String username = ConfigLoader.getInstance().getUsername();
		String password = ConfigLoader.getInstance().getPassword();

		HomePage homePage = loginPage.load().enterUsername(username).enterPassword(password).clickOnLoginButton();

		Assert.assertTrue(homePage.isHeadingMsgDisplayed(), "Heading message is not displayed");
		Assert.assertTrue(homePage.isFooterMsgDisplayed(), "Footer message is not displayed");
		Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in");

		ProductPage productPage = new ProductPage(getDriver());
		CartPage cartPage = productPage.clickOnAddTOCart().clickOnCartIcon();

		Assert.assertTrue(cartPage.isProductDisplayed(), "Product is not displayed in the cart");
		Assert.assertEquals(cartPage.getProductText(), "Sauce Labs Backpack", "Verification unsuccessful");

	}

}
