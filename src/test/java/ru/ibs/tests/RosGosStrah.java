package ru.ibs.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RosGosStrah {
    WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.rgs.ru");
    }

    @Test
    public void test() {
            //Click on companies
            WebElement companies = driver.findElement(By.xpath
                    ("//*[@id=\"__layout\"]/div/header/div/div/section[1]/div/nav/ul/li[2]/a"));
            companies.click();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Find iFrame and close
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'fl-616371')]")));
            driver.findElement(By.xpath("//div [@data-fl-track='click-close-login']")).click();
            driver.switchTo().defaultContent();

            //Click on Здоровье
            WebElement health = driver.findElement(By.cssSelector
                    ("#__layout > div > header > div > div " +
                            "> section.section.header-section.header-section--space-between.mobileHidden.section-categories " +
                            "> div > div > div.category-list > div > ul > li:nth-child(2)"));
            health = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(health));
            health.click();

            //Click on ДМС
            WebElement dms = driver.findElement(By.xpath(
                    "//*[@id=\"__layout\"]/div/header/div/div[2]/div[2]/div/div/div/section/div/div[2]/div[1]/div/div/ul/li[3]/a"
            ));
            dms = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(dms));
            dms.click();

            //Click on button
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            scroll(driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/main/div[1]/div/div[1]/section/div/div")), 0, 250);
            WebElement button = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/main/div[1]/div/div[1]/section/div/div/div/div[4]/button"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            button.click();

            //Fill the
            WebElement name = driver.findElement(By.xpath(
                    "//*[@id=\"__layout\"]/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[1]/div/div/div/input"));
            name.sendKeys("Апре Проим Куваф");

            driver.findElement(By.xpath(
                    "//*[@id=\"__layout\"]/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[2]/div/div/div/input"
            )).sendKeys("9110362390");

            WebElement email = driver.findElement(By.xpath(
                    "//*[@id=\"__layout\"]/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[3]/div/div/div/input"));
            email.sendKeys("qwertyqwerty");

//            TODO address doesn't work
//            driver.findElement(By.xpath(
//                    "//*[@id=\"__layout\"]/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[4]/div/div/div/div/div/div/input"
//            )).sendKeys("Санкт-Петербург, ул. Горького, д. 12");
//
//            scroll(driver.findElement(By.xpath("//input[@type= 'checkbox']")),0, 200 );
//            driver.findElement(By.xpath("//input[@type= 'checkbox']//..")).click();

        //Click on checkbox
        //TODO Doesn't work
//        WebElement checkbox = driver.findElement(By.xpath(
//                "//*[@id=\"accept\"]/div/label"
//        ));
//        checkbox.click();

//        driver.findElement(By.xpath(
//                "//*[@id=\"__layout\"]/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div/form/div/div[6]/div/button"
//        )).click();
    }

    public WebElement scroll(WebElement element, int x, int y) {
        String code = "window.scroll(" + (element.getLocation().x + x) +
                ", " + (element.getLocation().y + y) + ");";
        ((JavascriptExecutor) driver).executeScript(code, element, x, y);
        return element;
    }

    @After
    public void after() {
        driver.quit();
    }
}
