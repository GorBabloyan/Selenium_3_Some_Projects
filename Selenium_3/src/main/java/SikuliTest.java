import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.sikuli.script.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SikuliTest {
    public static WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ilovepdf.com/pdf_to_word");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //String id = driver.getWindowHandle();
    }

    @Test
    public void test1() throws FindFailed, InterruptedException {
        Screen k = new Screen();
        driver.findElement(By.xpath("//*[@id=\"pickfiles\"]/span")).click();
        Thread.sleep(1500);
        Screen scr = new Screen();
        System.out.println();
        scr.setOtherScreen();
        scr.setSize(1920,1080);
        System.out.println( scr.getName()+ "     "+scr.getScreen()+"   " +scr.getID()+"   " +scr.getIDString());
        scr.setAutoWaitTimeout(3);
        System.out.println(scr.capture());
        Pattern btn = new Pattern("D:\\Sikuli\\o.png");
        Pattern bt = btn.similar(0.3);
        Pattern text = new Pattern("D:\\Sikuli\\textbox_2.png");
        scr.wait(text,5);
        scr.type("C:\\Users\\user\\Desktop\\CV\\QA_CV\\Gor_Babloyan_CV_QA");

        scr.wait(bt,3);
        scr.click(bt);
        scr.wait(2);
        if (driver.getTitle().equals("OpenCart - Account Register")) {
            Assert.assertTrue(true);

        }

    }
}
