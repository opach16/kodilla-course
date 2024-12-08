package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://opach16.github.io";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanAfterTest() {
        driver.close();
    }

    @Test
    void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        deleteCrudAppTestTask(taskName);
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "/html/body/main/section[1]/form/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "/html/body/main/section[1]/form/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "/html/body/main/section[1]/form/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        Thread.sleep(2000);

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(5000);

        return taskName;
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(TRELLO_URL);

        Thread.sleep(10000);

        driver.findElement(By.id("username")).sendKeys("opach16@outlook.com");
        driver.findElement(By.id("login-submit")).submit();

        Thread.sleep(5000);

        driver.findElement(By.id("password")).sendKeys("netpuw-gugkaG-9pidza");
        driver.findElement(By.id("login-submit")).submit();

        Thread.sleep(10000);

        driver.findElement(By.xpath("//a[@class='board-tile']//div[text()='Kodilla Application']")).click();

        Thread.sleep(5000);

        result = driver.findElements(By.xpath("//a")).stream()
                .anyMatch(a -> a.getText().equals(taskName));

        driver.close();
        return result;
    }

    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {
        final String XPATH_DATATABLE = "//section[@class=\"datatable\"]//form";

        Thread.sleep(5000);

        driver.findElements(By.xpath(XPATH_DATATABLE)).stream()
                .filter(form -> !form.findElements(By.xpath(".//p[@data-task-name-paragraph]")).isEmpty())
                .filter(form -> form.findElement(By.xpath(".//p[@data-task-name-paragraph]")).getText().equals(taskName))
                .forEach(form -> form.findElement(By.xpath(".//button[@data-task-delete-button]")).click());

        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(5000);
    }
}
