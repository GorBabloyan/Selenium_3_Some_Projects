import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.time.Duration;

public class Sikuli {
    public static void main(String[] args) throws FindFailed, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.opencart.com/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Screen s = new Screen();

        Pattern email = new Pattern("C:\\Users\\user\\Desktop\\Sikuli_photo\\email.png");
        Pattern password = new Pattern("C:\\Users\\user\\Desktop\\Sikuli_photo\\password.png");
        Pattern loginButton = new Pattern("C:\\Users\\user\\Desktop\\Sikuli_photo\\3.png");

        //s.wait(email,2);
//        s.click(email);
//        s.type(email, "gorbabloyan@mail.ru");
//        s.click(password);
//        s.type(password, "12345678");
        s.click(loginButton);

        Thread.sleep(3000);
        driver.quit();

    }
}
