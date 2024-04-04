package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private final By textBoxUserName = By.id("user-name");
	private final By textBoxPassword = By.id("password");
	private final By btnLogin = By.id("login-button");
	private final By loginErrorMsg = By.xpath("//h3[@data-test='error']");
	private final By logoLoginPage = By.xpath("//div[@class='login_logo']");

	@Step
	public LoginPage load() {
		load(" ");
		return this;
	}

	public LoginPage enterUsername(String username) {
		sendKeys(textBoxUserName, username, WaitStrategy.PRESENCE, "Email Field");
		return this;
	}

	public LoginPage enterPassword(String password) {
		sendKeys(textBoxPassword, password, WaitStrategy.PRESENCE, "Password Field");
		return this;
	}

	public HomePage clickOnLoginButton() {
		click(btnLogin, WaitStrategy.CLICKABLE, "Login Button");
		return new HomePage(driver);
	}

	public boolean isErrorMessageDisplayed() {
		getText(loginErrorMsg, WaitStrategy.PRESENCE, "Invalid Credentials");
		return true;

	}

	public boolean isLogoDisplayed() {
		isDisplayed(logoLoginPage, WaitStrategy.PRESENCE, "Login Page");
		return true;
	}
	
}
