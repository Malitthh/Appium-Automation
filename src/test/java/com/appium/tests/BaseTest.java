package com.appium.tests;

import com.appium.pages.LoginPage;
import com.appium.utils.DriverFactory;
import com.appium.utils.ConfigReader;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {
        // Load config
        ConfigReader.loadProperties();

        // Initialize driver
        driver = DriverFactory.getDriver();

        // Login automatically if login page is visible
        LoginPage loginPage = new LoginPage(driver);
        if (loginPage.isLoginPageVisible()) {
            String username = ConfigReader.get("valid.username");
            String password = ConfigReader.get("valid.password");
            loginPage.login(username, password);
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
