package com.myHr.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

public class DriverHelperMethod extends WebDriverManager {

    private static final Logger LOG = LoggerFactory
            .getLogger(DriverHelperMethod.class);

    private static final long DRIVER_WAIT_TIME = 3;
    protected WebDriverWait wait;


    protected DriverHelperMethod() {
        this.wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
    }

    public String getCurrentPageTitle() {

        return getDriver().getTitle();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    protected WebElement waitForExpectedElement(final By by) {
        return wait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForExpectedElement(final By by, long waitTimeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTimeInSeconds);
            return wait.until(visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            LOG.info(e.getMessage());
            return null;
        } catch (TimeoutException e) {
            LOG.info(e.getMessage());
            return null;
        }
    }

    private ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) throws NoSuchElementException {
        return driver -> {
            WebElement element = getDriver().findElement(by);
            return element.isDisplayed() ? element : null;
        };
    }

    public static void switchToNextTab() {
        Set<String> tab = getDriver().getWindowHandles();
        Iterator<String> sessionID = tab.iterator();
        while (sessionID.hasNext()) {
            getDriver().switchTo().window(sessionID.next());
        }

    }

    public static void switchToFirstTab() {
        Set<String> tab = getDriver().getWindowHandles();
        Iterator<String> sessionID = tab.iterator();
        getDriver().switchTo().window(sessionID.next());
    }

    public Actions actions() {
        return new Actions(getDriver());
    }


}
