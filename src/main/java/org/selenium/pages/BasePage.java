
package org.selenium.pages;

import static org.selenium.constants.FrameworkConstants.WAIT;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.constants.FrameworkConstants;
import org.selenium.driver.DriverManager;
import org.selenium.enums.WaitStrategy;
import org.selenium.factories.ExplicitWaitFactory;
import org.selenium.reports.ExtentLogger;
import org.selenium.reports.ExtentManager;
import org.selenium.utils.ConfigLoader;
import org.selenium.utils.ScreenshotUtils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.util.concurrent.Uninterruptibles;

public class BasePage {

	private static final String ICON_NAVIGATE_RIGHT = null;
	/* Class level -> Not Thread safe */
	/*
	 * No need to use ThreadLocal, because when we are creating the Object of Page,
	 * those objects are local to test methods.
	 */
	protected WebDriver driver;
	protected WebDriverWait wait;

	/*
	 * Many waits can also be used in case you want to different time wait for
	 * different web elements
	 */

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, FrameworkConstants.getExplicitWait());

	}

	public void load(String endPoint) {
		driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
		ExtentLogger.info(ICON_NAVIGATE_RIGHT + "  Navigating to : <b>" + ConfigLoader.getInstance().getBaseUrl()
				+ endPoint + "</b>");
	}

	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (!overlays.isEmpty()) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAY INVISIBLE NOW");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	protected void isDisplayed(By by, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).isDisplayed();
		ExtentLogger.pass("<b>" + elementName + "</b> is Displayed", true);
	}

	protected boolean isEnabled(By by, WaitStrategy waitStrategy, String elementName) {
		boolean isEnabled = ExplicitWaitFactory.performExplicitWait(waitStrategy, by).isEnabled();
		ExtentLogger.pass("Is <b>" + elementName + "</b> Enabled? : " + isEnabled, true);
		return isEnabled;
	}

	protected boolean isSelected(By by, WaitStrategy waitStrategy, String elementName) {
		boolean isSelected = ExplicitWaitFactory.performExplicitWait(waitStrategy, by).isSelected();
		ExtentLogger.pass("Is <b>" + elementName + "</b> Selected? : " + isSelected, true);
		return isSelected;
	}

	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		ExtentLogger.pass("<b>" + elementName + "</b> is clicked", true);
	}

	protected static void jsClick(WebDriver driver, By elementBy, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, elementBy);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
		ExtentLogger.pass("Performed JavaScript click action on element <b>" + elementName + "</b>", true);
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
		ExtentLogger.pass("<b>" + value + "</b> is entered successfully in <b>" + elementName + "</b>", true);
	}

	protected void clear(By by, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).clear();
		ExtentLogger.info("Clearing the field  <b>" + elementName + "</b>");
	}

	protected void clearAndSendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.clear();
		element.sendKeys(value);
		ExtentLogger.pass("<b>" + value + "</b> is entered successfully in <b>" + elementName + "</b>", true);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public String getText(By by, WaitStrategy waitStrategy, String text) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).getText();
		ExtentLogger.pass("<b>" + text + "</b> is Message Displayed", true);
		return text;
	}

	protected void uploadFile(By by, String filePath, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(filePath);
		ExtentLogger.pass("File '" + filePath + "' is uploaded successfully to <b>" + elementName + "</b>", true);
	}

	protected void captureScreenshot() {
		ExtentManager.getExtentTest().info("Capturing Screenshot",
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}

	protected void waitForSomeTime() {
		Uninterruptibles.sleepUninterruptibly(WAIT, TimeUnit.SECONDS);
	}

	protected void waitForGivenTime(long time) {
		Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
	}

	protected void selectDropdownByIndex(By dropdownBy, int index, WaitStrategy waitStrategy, String dropdownName) {
		WebElement dropdownElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, dropdownBy);
		Select dropdown = new Select(dropdownElement);

		dropdown.selectByIndex(index);
		ExtentLogger.pass("Selected option by index " + index + " from dropdown <b>" + dropdownName + "</b>", true);
	}

	protected void selectDropdownByValue(By dropdownBy, String value, WaitStrategy waitStrategy, String dropdownName) {
		WebElement dropdownElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, dropdownBy);
		Select dropdown = new Select(dropdownElement);

		dropdown.selectByValue(value);
		ExtentLogger.pass("Selected option by value '" + value + "' from dropdown <b>" + dropdownName + "</b>", true);
	}

	protected void selectDropdownByVisibleText(By dropdownBy, String visibleText, WaitStrategy waitStrategy,
			String dropdownName) {
		WebElement dropdownElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, dropdownBy);
		Select dropdown = new Select(dropdownElement);

		dropdown.selectByVisibleText(visibleText);
		ExtentLogger.pass(
				"Selected option by visible text '" + visibleText + "' from dropdown <b>" + dropdownName + "</b>",
				true);
	}

	protected void selectDropdownBySendKeys(By dropdownBy, String value, WaitStrategy waitStrategy,
			String dropdownName) {
		WebElement dropdownElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, dropdownBy);

		dropdownElement.sendKeys(value);
		ExtentLogger.pass("Selected option by sending keys '" + value + "' to dropdown <b>" + dropdownName + "</b>",
				true);
	}

	protected static void switchToFrameById(WebDriver driver, String frameId) {
		driver.switchTo().frame(frameId);
		ExtentLogger.pass("Switched to frame with ID <b>" + frameId + "</b>", true);
	}

	protected static void switchToFrameByName(WebDriver driver, String frameName) {
		driver.switchTo().frame(frameName);
		ExtentLogger.pass("Switched to frame with name <b>" + frameName + "</b>", true);
	}

	protected static void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
		ExtentLogger.pass("Switched back to the default content", true);
	}

	protected static void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		ExtentLogger.pass("Switched to frame with element <b>" + frameElement.toString() + "</b>", true);
	}

}
