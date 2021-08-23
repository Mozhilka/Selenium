package by.yandex.steps;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexTest {
    WebDriver driver;

    @Test
    public void deliveryTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://yandex.by/");
        WebElement searchInputField = driver.findElement(By.xpath("//*[@id='text']"));
        searchInputField.sendKeys("Котики картинки");

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@tabindex='-1']")));
        WebElement searchButton = driver.findElement(By.xpath("//*[@tabindex='-1']"));
        searchButton.click();

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Яндекс"));

        driver.quit();
    }
}



