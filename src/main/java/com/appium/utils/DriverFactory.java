package com.appium.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverFactory {

    private static AppiumDriver driver;
    private static AppiumDriverLocalService service;

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {

            // Load config
            ConfigReader.loadProperties();

            // Start Appium server programmatically (optional)
            if (ConfigReader.get("startAppiumServer").equalsIgnoreCase("true")) {
                service = new AppiumServiceBuilder().usingAnyFreePort().build();
                service.start();
            }

            // Setup capabilities from config
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(ConfigReader.get("platformName"))
                    .setDeviceName(ConfigReader.get("deviceName"))
                    .setAutomationName(ConfigReader.get("automationName"))
                    .setAppPackage(ConfigReader.get("appPackage"))
                    .setAppActivity(ConfigReader.get("appActivity"))
                    .setApp(System.getProperty("user.dir") + "/" + ConfigReader.get("app"))
                    .setNewCommandTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.get("newCommandTimeout"))));

            URL serverURL = new URL(ConfigReader.get("appiumServerURL"));
            driver = new AndroidDriver(serverURL, options);
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
