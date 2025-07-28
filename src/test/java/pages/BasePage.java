package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static utilities.DriverSetUp.getDriver;

public class BasePage {

   public WebElement getElement(By locator){
     return getDriver().findElement(locator);
   }

   public void clickOnElement(By locator){
       getElement(locator).click();
   }
   public void writeOneElement(By locator ,String text){
       getElement(locator).sendKeys(text);
   }
   public boolean visibleState(By locator){
       return getElement(locator).isDisplayed();
   }
    public void loadAPage(String url){
         getDriver().get(url);
    }
    public String getPageTitle(){
      return getDriver().getTitle();
    }
    public String getElementText(By locator){
       return getElement(locator).getText();
    }
    public WebElement waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void addScreenShot(String name){
        Allure.addAttachment(name,new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }


}
