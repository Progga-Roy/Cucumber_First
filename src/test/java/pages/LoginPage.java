package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public String url  = "https://auth.wikimedia.org/enwiki/wiki/Special:UserLogin";
    public String user_Name = "Selenium1223";
    public String user_Name2 = "Selenium123";
    public String userPass = "automation223";
    public String userPass2 = "automation23";
    public String userEmail = "z7x71cqy9q@qejjyl.com";
    public String errorText = "Incorrect username or password entered. Please try again.";
    public By userInput = By.xpath("//input[@id='wpName1']");
    public By password = By.xpath("//input[@id='wpPassword1']");
    public By checkBox = By.xpath("//input[@id='wpRemember']");
    public By loginBtn = By.xpath("//button[@id='wpLoginAttempt']");
    public By errorMsg = By.xpath("//div[@class='cdx-message__content']");
    public By name = By.xpath("//span[contains(text(),'Selenium1223')]");
}
