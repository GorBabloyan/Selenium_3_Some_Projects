import org.testng.annotations.Test;

public class DataProvider {


    @Test(dataProvider = "loginDataProvider")     //If in this class we need to write dataProvider = "loginDataProvider"
    void logInTest(String mail, String password , String name){
        System.out.println(mail + " " + password + " " + name);
    }
    @org.testng.annotations.DataProvider
    public static Object[][] loginDataProvider() {
        Object data[][] = {{"abc@mail.ru","abc", "Gor"},{"xyz@mail.ru","xyz",null},{"mno@mail.ru","mno", "Mno"}};
        return data;
    }

}

