package _6_Selenium_Course_2;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Allure_listener.class})
public class Allure_Report_1 extends Base_Allure{


    @Test(priority = 1, description = "logo present in Home page")
    @Description("Verify Logo present in Home page.....")
    @Epic("EP001")
    @Feature("Feature 1: Logo")
    @Story("Story: Valid logo")
    @Step("logo verification")
    @Severity(SeverityLevel.BLOCKER)
    public void logoTest() {
        WebElement logo = driver.findElement(By.xpath( "/html/body/header/nav/div/div[1]/a/img"));
        boolean isDisplayed = logo.isDisplayed();
        Assert.assertEquals(isDisplayed,true);
    }


    @Test(priority = 3)
    @Description("Verify Login from Home page.....")
    @Epic("EP001")
    @Feature("Feature 2: Login")
    @Story("Story: Valid login")
    @Step("login verification")
    @Severity(SeverityLevel.MINOR)
    public void loginTest(){
        throw new SkipException("Skip this test");
    }

    @Test(priority = 2)
    @Description("Verify registration from Home page.....")
    @Epic("EP001")
    @Feature("Feature: Registration")
    @Story("Story: Validation Registration")
    @Step("Registration verification")
    @Severity(SeverityLevel.NORMAL)
    public void registrationTest(){
        driver.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/div/a[2]")).click();
        Assert.assertEquals(driver.getTitle(),"OpenCart - Account Register 123");

    }
}
