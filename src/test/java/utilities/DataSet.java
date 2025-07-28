package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidUserCredentials")
    public static  Object invalidCredentials(){
        Object[][] data = {
                {"auto","automation223","Incorrect username or password entered. Please try again."},
                {"Selenium1223","selenium","Incorrect username or password entered. Please try again."},
                {"yru7uieeu","jjk89389","Incorrect username or password entered. Please try again."}
        };
        return data;
    }


}
