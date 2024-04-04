package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	private final By firstName = By.cssSelector("#first-name");
	private final By lastName = By.cssSelector("#last-name");
	private final By pinCode = By.cssSelector("#postal-code");
	private final By checkOutInfoMsg = By.cssSelector(".title");

	public CheckOutPage enterFirstName(String fname) {
		sendKeys(firstName, fname, WaitStrategy.PRESENCE, "First Name Field");
		return this;
	}

	public CheckOutPage enterLastName(String lName) {
		sendKeys(lastName, lName, WaitStrategy.PRESENCE, "Last Name Field");
		return this;
	}

	public CheckOutPage enterPinCode(String pCode) {
		sendKeys(pinCode, pCode, WaitStrategy.PRESENCE, "Pin Code Field");
		return this;
	}

	public String getInfoText() {
		return getText(checkOutInfoMsg, WaitStrategy.PRESENCE, "Checkout: Your Information");

	}

}
