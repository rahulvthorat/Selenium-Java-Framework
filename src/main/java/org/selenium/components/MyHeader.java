package org.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;
import org.selenium.pages.BasePage;

public class MyHeader extends BasePage {

	public MyHeader(WebDriver driver) {
		super(driver);

	}

	private final By headingSwagLabs = By.xpath("//div[@class='app_logo']");

	/* Fluent Interface */
	public boolean getHeaderMsg() {
		isDisplayed(headingSwagLabs, WaitStrategy.PRESENCE, "Swag Labs");
		return true;
	}

}
