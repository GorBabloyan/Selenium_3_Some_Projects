package ACA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Register {

    public String generateRandomEmail(){
        String randomEmail;
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        randomEmail = generatedString + "@gmail.com";
        return randomEmail;
    }
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\"content_price\"]"));
        Actions action = new Actions(driver);
        for (WebElement element : elements) {
            String text = element.getText();
            if (text.contains("%")) {
                action.moveToElement(element).perform();
                List<WebElement> all = driver.findElements(By.xpath("//span[contains(text(),'Add to cart')]"));
                for (WebElement one : all) {
                    if (one.isDisplayed()) {
                        one.click();
                        WebElement close =driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span"));
                        close.click();
                    }
                }
            }
        }
        WebElement cart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
        cart.click();
        WebElement toCheckout =driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
        toCheckout.click();
        WebElement email = driver.findElement(By.name("email_create"));
        email.sendKeys(generateRandomEmail());
        WebElement submitCreate = driver.findElement(By.id("SubmitCreate"));
        submitCreate.click();

        WebElement gender = driver.findElement(By.id("id_gender1"));
        WebElement firstName = driver.findElement(By.name("customer_firstname"));
        WebElement lastName = driver.findElement(By.name("customer_lastname"));
        WebElement passwd = driver.findElement(By.name("passwd"));
        WebElement day = driver.findElement(By.id("days"));
        WebElement month = driver.findElement(By.id("months"));
        WebElement year = driver.findElement(By.id("years"));
        WebElement address = driver.findElement(By.id("address1"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement state = driver.findElement(By.id("id_state"));
        Select st = new Select(state);
        WebElement zip = driver.findElement(By.id("postcode"));
        WebElement number = driver.findElement(By.id("phone"));
        WebElement submit = driver.findElement(By.id("submitAccount"));


        gender.click();
        firstName.sendKeys("Gor");
        lastName.sendKeys("Gor");
        passwd.sendKeys("12345678");
        day.sendKeys("10");
        month.sendKeys("november");
        year.sendKeys("1990");
        address.sendKeys("Armenia Yerevan haywey  35/75 ");
        city.sendKeys("Yerevan");
        st.selectByVisibleText("Arizona");
        zip.sendKeys("00123");
        number.sendKeys("123456789");
        submit.click();
        String title = driver.getTitle();

        Assert.assertEquals(title,"Order - My Store");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
