package com.example.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class ViewsPage {
    private AndroidDriver driver;

    // constructor
    public ViewsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // locator for "Views" menu
    public WebElement viewsMenu() {
        return driver.findElement(AppiumBy.accessibilityId("Views"));
    }

    // locator for "Buttons" option inside Views
    public WebElement buttonsOption() {
        return driver.findElement(AppiumBy.accessibilityId("Buttons"));
    }

    // locator for the first button on the Buttons page
    public WebElement firstButton() {
        return driver.findElement(AppiumBy.id("io.appium.android.apis:id/button"));
    }
}
