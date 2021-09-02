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

import java.time.Duration;

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

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']")));
        WebElement newSearchButton = driver.findElement(By.xpath("//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']"));
        newSearchButton.click();

        WebElement wizardHeader = driver.findElement(By.xpath("//*[@class='WizardHeader-Title-Text']"));
        wizardHeader.click();

        WebElement searchButtonField = driver.findElement(By.xpath("//*[text()='Видео']"));
        searchButtonField.click();

        WebElement newSearchInputField = driver.findElement(By.xpath("//*[@class='search2__input']"));
        newSearchInputField.click();


    }

    @After
    public void cleanUp() {

        driver.quit();
    }

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver", "src/test/resources/chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}



