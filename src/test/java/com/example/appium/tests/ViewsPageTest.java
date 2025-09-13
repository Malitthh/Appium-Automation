package com.example.appium.tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.appium.driver.DriverFactory;
import com.example.appium.pages.ViewsPage;

public class ViewsPageTest {

	private AndroidDriver driver;
	private ViewsPage viewsPage;

	@BeforeClass
	public void setUp() {
		driver = (AndroidDriver) DriverFactory.getDriver();
		viewsPage = new ViewsPage(driver);
	}

	@Test
	public void testViewsPage() {
		viewsPage.viewsMenu().click();
		viewsPage.buttonsOption().click();
		viewsPage.firstButton().click();

		System.out.println("ViewsPage Test Executed");
	}

	@AfterClass
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
