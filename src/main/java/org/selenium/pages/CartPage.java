package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	private final By cartProduct = By.cssSelector(".inventory_item_name");
	private final By checkOutLinkBy =By.cssSelector("#checkout");

	public boolean isProductDisplayed() {

		isDisplayed(cartProduct, WaitStrategy.PRESENCE, "Sauce Labs Backpack");
		return true;
	}
	
	public String getProductText() {
		return getText(cartProduct, WaitStrategy.PRESENCE, "Sauce Labs Backpack");
		
	}
	
	public CheckOutPage clickOnCheckOut() {
		click(checkOutLinkBy, WaitStrategy.CLICKABLE, "Checkout Button");
		return new CheckOutPage(driver);
	}
}
