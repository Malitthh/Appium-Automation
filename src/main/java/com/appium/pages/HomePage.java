package com.appium.pages;

import com.appium.utils.ConfigReader;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

	private final AppiumDriver driver;
	private final WebDriverWait wait;

	public HomePage(AppiumDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private final By homePageTitle = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");
	private final By productTitles = AppiumBy.xpath("//android.widget.TextView[@content-desc='test-Item title']");
	private final By toggleIcons = AppiumBy
			.xpath("//android.view.ViewGroup[@content-desc='test-Toggle']/android.widget.ImageView");
	private final By addButtons1 = AppiumBy.xpath("(//android.widget.TextView[@text=\"+\"])[1]");
	private final By addButtons2 = AppiumBy.xpath("(//android.widget.TextView[@text=\"+\"])[2]");
	private final By removeButtons = AppiumBy.xpath("//android.widget.TextView[@text=\"-\"]");
	private final By filterButton = AppiumBy.xpath(
			"//android.view.ViewGroup[@content-desc='test-Modal Selector Button']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
	private final By sortPriceLowToHigh = AppiumBy.xpath("//android.widget.TextView[@text='Price (low to high)']");

	// --- Page checks ---
	public boolean isPageLoaded() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageTitle)).isDisplayed();
	}

	// --- Product list ---
	public List<WebElement> getProductTitles() {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles));
	}

	// --- Actions ---
	public void tapToggleIcon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(toggleIcons)).click();
	}

	public void tapFirstAddButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addButtons1)).click();
	}

	public void tapSecondAddButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addButtons2)).click();
	}

	public void tapFirstRemoveButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(removeButtons)).click();
	}

	public void tapFilterButton() {
		wait.until(ExpectedConditions.elementToBeClickable(filterButton)).click();
	}

	public void tapSortPriceLowToHigh() {
		wait.until(ExpectedConditions.elementToBeClickable(sortPriceLowToHigh)).click();
	}

	// --- Scroll and select product ---
	public void scrollToProductAndSelect(String productName) {
		String uiScroll = String.format(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",
				productName);
		driver.findElement(AppiumBy.androidUIAutomator(uiScroll));
		driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiSelector().text(\"%s\")", productName)))
				.click();
	}
}
