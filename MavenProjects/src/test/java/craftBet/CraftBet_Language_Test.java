package craftBet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CraftBet_Language_Test {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://craftbet.com/");
        driver.manage().window().maximize();

    }
    @Test
    public void languageTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-header/div/div/div/div[1]/ul/div/li[3]/div/app-global-language/div/div")).click();
        List<WebElement> languages = driver.findElements(By.xpath("//*[@id=\"main-container\"]/app-header/div/div/div/div[1]/ul/div/li[3]/div/app-global-language/div/ul/div/li"));
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-header/div/div/div/div[1]/ul/div/li[3]/div/app-global-language/div/div")).click();
        int i = 0;
        for (WebElement language:languages){
            driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-header/div/div/div/div[1]/ul/div/li[3]/div/app-global-language/div/div")).click();
            language.click();
            String actualTitle = driver.getTitle();
            String expectedTitle = "CraftBet | Sports Betting & Casino";
            if (actualTitle.equals(expectedTitle)){
                Assert.assertTrue(true);
            }
            else{
                System.out.println(driver.getTitle());
                i++;
            }

        }
        if (i>0){
            Assert.fail();
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

//*[@id="main-container"]/app-header/div/div/div/div[1]/ul/div/li[3]/div/app-global-language/div
//*[@id="main-container"]/app-header/div/div/div/div[1]/ul/div/li[3]/div/app-global-language/div

//*[@id="main-container"]/app-header/div/div/div/div[1]/ul/div/li[3]/div/app-global-language/div/ul/div[2]/li[7]/div/span