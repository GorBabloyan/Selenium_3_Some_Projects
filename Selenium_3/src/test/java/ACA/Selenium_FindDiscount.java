package ACA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Selenium_FindDiscount {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test
    public void ErrorMassageTest_1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\"content_price\"]"));
        Actions action = new Actions(driver);
        for (WebElement element : elements) {
            String text = element.getText();
            if (text.contains("%")) {
                action.moveToElement(element).perform();
                break;
            }
        }
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        driver.findElement(By.id("email")).sendKeys("abcd@mail.ru");
        driver.findElement(By.id("passwd")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        String errorMassage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errorMassage, "Authentication failed.");

    }

    @Test
    public void errorMassageTest_2() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Actions action = new Actions(driver);
        WebElement myElement = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[1]/span"));
        action.moveToElement(myElement).perform();
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        driver.findElement(By.id("email")).sendKeys("abcd@mail.ru");
        driver.findElement(By.id("passwd")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        String errorMassage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errorMassage, "Authentication failed(Not equal massage)");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
