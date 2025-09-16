package com.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final AppiumDriver driver;
    private final WebDriverWait wait;

    //class-level locators
    private final By addToCartScroll = AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))"
                    + ".scrollIntoView(new UiSelector().text(\"ADD TO CART\"))"
    );
    private final By addToCartBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\")");
    private final By cartIcon = AppiumBy.xpath(
            "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"
    );

    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void scrollToAddToCartAndTap() {
        driver.findElement(addToCartScroll); // Scroll into view
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartButton.click();
    }

    public void tapCartIcon() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cart.click();
    }
}
