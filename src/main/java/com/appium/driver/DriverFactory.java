package com.appium.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverFactory {

	private static AppiumDriver driver;
	private static AppiumDriverLocalService service;

	public static AppiumDriver getDriver() {
		if (driver == null) {
			// Start Appium server programmatically (optional).
			service = new AppiumServiceBuilder().usingAnyFreePort().build();
			service.start();

			UiAutomator2Options options = new UiAutomator2Options().setPlatformName("Android")
					.setDeviceName("emulator-5554") // device name
					.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk")
					.setAutomationName("UiAutomator2");

			driver = new AndroidDriver(service.getUrl(), options);
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (service != null) {
			service.stop();
			service = null;
		}
	}
}
