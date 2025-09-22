package com.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final AppiumDriver driver;
    private final WebDriverWait wait;

    //locators
    private final By checkoutBtn = AppiumBy.accessibilityId("test-CHECKOUT");
    private final By continueBtn = AppiumBy.accessibilityId("test-CONTINUE");
    private final By errorMsg = AppiumBy.accessibilityId("test-Error message");
    private final By firstNameField = AppiumBy.accessibilityId("test-First Name");
    private final By lastNameField = AppiumBy.accessibilityId("test-Last Name");
    private final By postalCodeField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private final By finishBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"FINISH\")");
    private final By backHomeBtn = AppiumBy.accessibilityId("test-BACK HOME");

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void tapCheckout() {
        String uiScrollToElement = "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().description(\"test-CHECKOUT\"))";
        driver.findElement(AppiumBy.androidUIAutomator(uiScrollToElement));

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkout.click();
    }

    public void tapContinue() {
        WebElement continueElement = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueElement.click();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return error.isDisplayed();
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void scrollToFinishAndTap() {
        String uiScroll = "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\"FINISH\"))";
        driver.findElement(AppiumBy.androidUIAutomator(uiScroll));

        WebElement finish = wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finish.click();
    }

    public void tapBackHome() {
        WebElement backHome = wait.until(ExpectedConditions.elementToBeClickable(backHomeBtn));
        backHome.click();
    }
}
