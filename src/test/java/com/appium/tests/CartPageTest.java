package com.appium.tests;

import com.appium.pages.CartPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartPageTest extends BaseTest {

	@Test
	public void testCheckoutFlow() {
		CartPage cartPage = new CartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		cartPage.tapCheckout();

		cartPage.tapContinue();
		Assert.assertTrue(cartPage.isErrorMessageDisplayed(),
				"Error message should be displayed when continue tapped without data");

		cartPage.fillCheckoutForm("Soap", "Mactavish", "20080");

		cartPage.tapContinue();

		cartPage.scrollToFinishAndTap();

		boolean backHomeBtnVisible = wait
				.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-BACK HOME")))
				.isDisplayed();
		Assert.assertTrue(backHomeBtnVisible, "Back Home button should be visible after finishing checkout");

		cartPage.tapBackHome();
	}
}
