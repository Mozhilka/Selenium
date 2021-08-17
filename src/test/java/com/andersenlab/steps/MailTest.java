package com.andersenlab.steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailTest {
    WebDriver driver;

    @Test
    public void emailTest() {
        driver.get("https://mail.ru");
        WebElement emailInput = driver.findElement(By.xpath("//*[text()='Имя ящика']"));
        emailInput.sendKeys("est1q2w3eas");
        emailInput.submit();

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
