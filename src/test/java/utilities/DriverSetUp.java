package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverSetUp {
   private static final String browser_name = System.getProperty("browser","Chrome");
   private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DriverSetUp.DRIVER_THREAD_LOCAL.set(driver);
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

   @BeforeMethod
    public void startBrowser(){
     WebDriver driver = getBrowser(browser_name);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         setDriver(driver);
    }
    @AfterMethod
    public void closeBrowser(){
//          driver.close();
        getDriver().quit();
    }

    public WebDriver getBrowser(String name) {
        if (name.equalsIgnoreCase("Chrome")) {
            return new ChromeDriver();
        }
        else if(name.equalsIgnoreCase("edge")){
            return new EdgeDriver();
        }
        else if(name.equalsIgnoreCase("firefox")){
            return new FirefoxDriver();
        }
        else{
           throw new RuntimeException("Browser is not available with this name : " + name);
        }
    }


}
