package com.myHr.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class WebDriverManager {


    private static WebDriver driver;

    public WebDriverManager() {
        setDriver();
    }


    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikrants\\Music\\drivers\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }


}
