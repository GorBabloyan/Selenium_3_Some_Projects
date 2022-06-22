package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_1 {
    @Test
    public void test1(){
        System.out.println("Test will pass");
        Assert.assertEquals("Gor","Gor");
    }
    @Test
    public void test2(){
        System.out.println("Test will fail");
        Assert.assertEquals("Gor","Goor");
    }
}
