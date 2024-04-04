package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.components.MyFooter;
import org.selenium.components.MyHeader;
import org.selenium.enums.WaitStrategy;

public class HomePage extends BasePage {

	private MyHeader appHeader;
	private MyFooter appFooter;

	public MyHeader getAppHeader() {
		return appHeader;
	}

	public MyFooter getAppFooter() {
		return appFooter;
	}

	public HomePage(WebDriver driver) {
		super(driver);
		appHeader = new MyHeader(driver);
		appFooter = new MyFooter(driver);

	}

	private final By linkLogoutSideBar = By.id("react-burger-menu-btn");
	private final By linkLogout = By.id("logout_sidebar_link");

	public HomePage load() {
		load("");
		return this;
	}

	public boolean isHeadingMsgDisplayed() {
		return appHeader.getHeaderMsg();
	}

	public boolean isFooterMsgDisplayed() {
		return appFooter.getFooterMsg();
	}

	public boolean isUserLoggedIn() {
		String pageTitle = getPageTitle();
		return pageTitle.contains("Swag Labs");
	}

	public void clickOnLogoutSideBar() {
		click(linkLogoutSideBar, WaitStrategy.CLICKABLE, "Logout side bar");
	}

	public void clickOnLogout() {
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout");
	}

}
