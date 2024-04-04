package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.LoginPage;
import org.selenium.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageLogoutTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.SMOKE,
			CategoryType.BVT, CategoryType.REGRESSION })

	@Test
	public void loginAndLogout() {

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

		homePage.clickOnLogoutSideBar();
		homePage.clickOnLogout();

		Assert.assertTrue(loginPage.isLogoDisplayed(), "Login Page not displayed");

	}
	

}
