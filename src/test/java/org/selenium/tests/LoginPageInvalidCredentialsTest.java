package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.dataproviders.LoginDataProvider;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageInvalidCredentialsTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.SMOKE,
			CategoryType.BVT, CategoryType.REGRESSION })

	@Test(dataProvider = "InvalidData", dataProviderClass = LoginDataProvider.class)
	public void loginWithInvalidCredentialsValidation(String username,String password) {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage
		.load()
		.enterUsername(username)
		.enterPassword(password)
		.clickOnLoginButton();

		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");

	}
}
