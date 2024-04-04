package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public ProductPage load() {
		load();
		return this;
	}

	private final By addToCartSauceLabsBackpack = By.cssSelector("#add-to-cart-sauce-labs-backpack");
	private final By addToCartIcon = By.cssSelector(".shopping_cart_link");
	private final By priceDropdown = By.cssSelector(".product_sort_container");

	public ProductPage clickOnAddTOCart() {
		click(addToCartSauceLabsBackpack, WaitStrategy.CLICKABLE, "Add to cart");
		return this;
	}

	public CartPage clickOnCartIcon() {
		click(addToCartIcon, WaitStrategy.CLICKABLE, "shopping-cart-link");
		return new CartPage(driver);
	}

	public void selectPriceDropdownByVisibleText(String visibleText) {
		selectDropdownByVisibleText(priceDropdown, visibleText, WaitStrategy.CLICKABLE, "Price Dropdown");
	}

}
