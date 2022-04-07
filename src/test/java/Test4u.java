import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test4u {

    public static WebDriver driver;
    public static String baseURL = "https://www.google.com";

    @BeforeTest
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/armanbabayan/IdeaProjects/gitLab/AutomationProject/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void didSearchOpen() {
        driver.get("https://www.4u.am");
        driver.findElement(By.cssSelector("[id='searchForm'] input")).sendKeys("Rose", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > section.heading_section > h3")).getText(), "ՈՐՈՆՄԱՆ ԱՐԴՅՈՒՆՔՆԵՐ", "Searching for an item did not work.");
    }

    @Test
    public void didFlowersOpen() {
        driver.get("https://www.4u.am");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/ul/li[4]/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://4u.am/hy/category/flowers", "'Flowers' section did not open.");
    }

    @Test
    public void didLogoTakeToHomePage() {
        driver.get("https://www.4u.am");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[1]/a/img")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://4u.am/hy/", "Clicking on the logo did not take to homepage.");
    }

    @Test
    public void isOrderDisplayedWhenClickingOnBasket() throws InterruptedException {
        driver.get("https://www.4u.am");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("basketIcon")).click();
        TimeUnit.SECONDS.sleep(1);
        Assert.assertTrue(driver.findElement(By.className("basket_make_order")).isDisplayed());
    }
}
