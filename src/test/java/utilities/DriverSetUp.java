package utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverSetUp {
//   private static final String browser_name = System.getProperty("browser","Chrome");
   private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DriverSetUp.DRIVER_THREAD_LOCAL.set(driver);
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }


    public static void startBrowser(String browser_name){
     WebDriver driver = getBrowser(browser_name);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         setDriver(driver);
    }

    public static void closeBrowser(Scenario scenario){
//          driver.close();
        takeScreenShotOnFailedCase(scenario);
        getDriver().quit();
    }

    public static WebDriver getBrowser(String name) {
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
    public static void takeScreenShotOnFailedCase(Scenario scenario){
        if(scenario.isFailed()){
            String name = scenario.getName().replaceAll(" ", "_");
            byte[] source =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source, "image/png", name);
        }



    }

}
