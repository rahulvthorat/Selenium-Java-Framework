package org.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;
import org.selenium.pages.BasePage;

public class MyFooter extends BasePage {

	public MyFooter(WebDriver driver) {
		super(driver);

	}

	private final By footerMsg = By.xpath("//div[@class='footer_copy']");

	/* Fluent Interface */
	public boolean getFooterMsg() {
		isDisplayed(footerMsg, WaitStrategy.PRESENCE,
				" Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
		return true;
	}

}
