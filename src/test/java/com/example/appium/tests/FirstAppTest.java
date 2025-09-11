package com.example.appium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class FirstAppTest extends BaseTest {

	@Test
	public void testOpenAppAndClick() {
		// Example: Open "Views" in ApiDemos
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

		// Validate element is visible after click
		boolean isDisplayed = driver.findElement(By.xpath("//android.widget.TextView[@text='Animation']"))
				.isDisplayed();
		Assert.assertTrue(isDisplayed, "Animation menu should be visible after opening Views");
	}
}
