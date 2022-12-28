package ru.ibs.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RosGosStrah {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.rgs.ru");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fl-616371"))).click();
        WebElement frame = driver.findElement(By.id("fl-616371"));

        WebElement close = frame.findElement(By.xpath("/html/body/div/div[1]/div[1]/div"));
        close.click();

        driver.switchTo().defaultContent();

        WebElement forCompanies = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div/section[1]/div/nav/ul/li[2]/a"));
        forCompanies.click();

        WebElement health = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div/section[2]/div/div/div[1]/div/ul/li[2]/span"));
        health.click();

        WebElement dms = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[2]/section/div/div/div/div/div[1]/div/div[1]/div/a"));
        dms.click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[1]/section/div/div/div/div[2]/h1")).isDisplayed();

        WebElement send = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[1]/section/div/div/div/div[4]/button"));
        send.click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]")).isDisplayed();

        WebElement name = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[1]/div/div/div/input"));
        name.sendKeys("Иванов Иван Иванович");

        WebElement phone = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[2]/div/div/div/input"));
        phone.sendKeys("+79114550923");

        WebElement email = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[3]/div/div/div/input"));
        email.sendKeys("qwertyqwerty");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[3]/div/div/span")).isDisplayed();

        WebElement address = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[4]/div/div/div/div/div/div/input"));
        address.sendKeys("СПб, Устинова ул., 23, 44");

        WebElement agree = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[5]/div/div/label/input"));
        agree.click();

        email.sendKeys("jhgf@bk.ru");

        WebElement buttonOrder = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[6]/div/button"));
        buttonOrder.click();

        driver.quit();
    }
}
