import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Xoom_Link_Test {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://craftbet.com/home");
        driver.manage().window().maximize();
    }


    @Test
    public void linkTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int size = links.size();
        System.out.println("links ara------------------------->: " +size);

        int i=0;
        for (WebElement link:links){

            String url = link.getAttribute("href");
            System.out.println(i+ "   " + url);
//            if (url==null||url.isEmpty()){
//                System.out.println(link.getText() + "  <------------------------Empty link");
//            }
//            try {
//                URL Url = new URL(url);
//                HttpURLConnection connection = (HttpURLConnection)Url.openConnection();
//                //connection.setConnectTimeout(1000);
//                connection.connect();
//                int cod = connection.getResponseCode();
//
//                if (cod>=400){
//                    System.out.println("Broken link --------------------------> " + url  + cod);
//                }
//                else {
//                    System.out.println(url + "   ------------------------> " + cod);
//                }
//            }
//
//            catch (Exception e){
//
//                System.out.println("Exception is--------------------->"+ url + e);
//                i++;
//            }
        }
    //    System.out.println("Exceptions are  "+i);
        i++;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
