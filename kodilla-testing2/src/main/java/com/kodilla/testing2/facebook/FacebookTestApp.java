package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestApp {

    public static final String URL = "https://www.facebook.com";
    public static final String ACCEPT_ALL = "//div[@class='x9f619 x1ja2u2z x78zum5 x2lah0s x1n2onr6 x1qughib x1qjc9v5 x8hhl5t x1q0g3np xyamay9 xcud41i x139jcc6 x4vbgl9 x1rdy4ex']/div[2]";
    public static final String REGISTER_BUTTON_ID = "//a[@data-testid='open-registration-form-button']";
    public static final String DAY = "//div[@class='_5k_5']//select[1]";
    public static final String MONTH = "//div[@class='_5k_5']//select[2]";
    public static final String YEAR = "//div[@class='_5k_5']//select[3]";
    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptAllCookies = wait.until(a -> a.findElement(By.xpath(ACCEPT_ALL)));
        acceptAllCookies.click();

        driver.findElement(By.xpath(REGISTER_BUTTON_ID)).click();

        WebElement acceptAllCookies1 = wait.until(a -> a.findElement(By.xpath(ACCEPT_ALL)));
        acceptAllCookies1.click();

        Select selectDay = new Select(driver.findElement(By.xpath(DAY)));
        Select selectMonth = new Select(driver.findElement(By.xpath(MONTH)));
        Select selectYear = new Select(driver.findElement(By.xpath(YEAR)));

        selectDay.selectByValue("11");
        selectMonth.selectByValue("16");
        selectYear.selectByValue("1992");
    }
}