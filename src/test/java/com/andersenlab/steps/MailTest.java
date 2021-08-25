package com.andersenlab.steps;

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

public class MailTest {
    WebDriver driver;

    @Test
    public void emailTest() throws InterruptedException {
        driver.get("https://mail.ru");
        WebElement emailInputField = driver.findElement(By.xpath("//*[@placeholder='Имя ящика']"));
        emailInputField.sendKeys("est1q2w3eas");

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='enter-password']")));
        WebElement enterPasswordButton = driver.findElement(By.xpath("//button[@data-testid='enter-password']"));
        enterPasswordButton.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='password']")));
        WebElement passwordInputField = driver.findElement(By.xpath("//*[@type='password']"));
        passwordInputField.sendKeys("Kfu~9]Fk5]S*8~*");

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-to-mail']")));
        WebElement enterEmailButton = driver.findElement(By.xpath("//button[@data-testid='login-to-mail']"));
        enterEmailButton.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Написать письмо']")));
        WebElement newEmailButton = driver.findElement(By.xpath("//*[text()='Написать письмо']"));
        newEmailButton.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='container--H9L5q size_s--3_M-_']")));
        WebElement recipientField = driver.findElement(By.xpath("//*[@class='container--H9L5q size_s--3_M-_']"));
        recipientField.sendKeys("est1q2w3eas@mail.ru");

        WebElement contentInput = driver.findElement(By.xpath("//div[@contenteditable='true']/div"));
        contentInput.sendKeys("Привет Оля");

        WebElement sendButton = driver.findElement(By.xpath("//*[text()='Отправить']"));
        sendButton.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'button2 button2_has-ico button2_has-ico-s button2_close')]")));
        WebElement crossButton = driver.findElement(By.xpath("//*[contains(@class, 'button2 button2_has-ico button2_has-ico-s button2_close')]"));
        crossButton.click();

        WebElement sentEmailsPane = driver.findElement(By.xpath("//*[text()='Отправленные']"));
        sentEmailsPane.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='est1q2w3eas@mail.ru']/..")));
        WebElement sentEmails = driver.findElement(By.xpath("//*[@title='est1q2w3eas@mail.ru']/.."));
        sentEmails.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='letter-body']")));
        WebElement contentDiv = driver.findElement(By.xpath("//div[@class='letter-body']"));

        Assert.assertTrue(contentDiv.getText().contains("Привет Оля"));

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

