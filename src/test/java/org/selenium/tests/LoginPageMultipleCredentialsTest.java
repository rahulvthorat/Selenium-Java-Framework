package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.dataproviders.LoginDataProvider;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageMultipleCredentialsTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.SMOKE,
			CategoryType.BVT, CategoryType.REGRESSION })

	@Test(dataProvider = "ValidData", dataProviderClass = LoginDataProvider.class)
	public void loginWithMultipleCredentials(String username, String password) {
		LoginPage loginPage = new LoginPage(getDriver());
		HomePage homePage = loginPage
				.load()
				.enterUsername(username)
				.enterPassword(password)
				.clickOnLoginButton();

		Assert.assertTrue(homePage.isHeadingMsgDisplayed(), "Heading message is not displayed");
		Assert.assertTrue(homePage.isFooterMsgDisplayed(), "Footer message is not displayed");
		Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in");
	}

}
