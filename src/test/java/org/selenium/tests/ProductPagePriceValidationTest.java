package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.LoginPage;
import org.selenium.pages.ProductPage;
import org.selenium.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPagePriceValidationTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.SMOKE,
			CategoryType.BVT, CategoryType.REGRESSION })

	@Test
	public void PriceDropdownValidation() {
		LoginPage loginPage = new LoginPage(getDriver());

		String username = ConfigLoader.getInstance().getUsername();
		String password = ConfigLoader.getInstance().getPassword();

		HomePage homePage = loginPage.load().enterUsername(username).enterPassword(password).clickOnLoginButton();

		Assert.assertTrue(homePage.isHeadingMsgDisplayed(), "Heading message is not displayed");
		Assert.assertTrue(homePage.isFooterMsgDisplayed(), "Footer message is not displayed");
		Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in");

		ProductPage productPage = new ProductPage(getDriver());
		productPage.selectPriceDropdownByVisibleText("Price (low to high)");

	}

}
