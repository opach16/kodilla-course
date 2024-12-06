package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class WebDriverConfig {

    public static final String CHROME = "CHROME_DRIVER";
    public static final String SAFARI = "SAFARI_DRIVER";

    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.chrome.driver", "/Users/konrad/Documents/Development/Projects/Kodilla/chromedriver-mac-arm64/chromedriver");

        if (driver.equals(CHROME)) {
            return new ChromeDriver();
        } else if (driver.equals(SAFARI)) {
            SafariOptions options = new SafariOptions();
            return new SafariDriver(options);
        } else {
            return null;
        }
    }
}
