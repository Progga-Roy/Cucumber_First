package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utilities.DataSet;
import utilities.DriverSetUp;

public class TestLoginPage extends DriverSetUp {
    MainPage mainPage = new MainPage();
    LoginPage login_page = new LoginPage();
    @Test(description ="Test Login with Valid Credentials")
    public void TestUserCanLoginWithValidCredentials(){
        mainPage.loadAPage(mainPage.url);
//        mainPage.addScreenShot("Main page");
        mainPage.clickOnElement(mainPage.login_btn);
        login_page.writeOneElement(login_page.userInput,login_page.user_Name);
        login_page.writeOneElement(login_page.password,login_page.userPass);
        login_page.clickOnElement(login_page.checkBox);
        login_page.clickOnElement(login_page.loginBtn);
//        login_page.addScreenShot("Login page after entering name and password");
        Assert.assertEquals(mainPage.getElementText(mainPage.name),login_page.user_Name);
        Assert.assertTrue(mainPage.waitForElement(mainPage.user_icon).isDisplayed());
    }  @Test
    public void TestUserCanLoginWithInvalidUserName(){
        mainPage.loadAPage(mainPage.url);
        mainPage.clickOnElement(mainPage.login_btn);
        login_page.writeOneElement(login_page.userInput,"auto");
        login_page.writeOneElement(login_page.password,login_page.userPass);
        login_page.clickOnElement(login_page.checkBox);
        login_page.clickOnElement(login_page.loginBtn);
//        Assert.assertEquals(mainPage.visibleState(mainPage.login_btn));
        Assert.assertEquals(login_page.getElementText(login_page.errorMsg),login_page.errorText);
        Assert.assertTrue(login_page.visibleState(login_page.loginBtn));
    }  @Test
    public void TestUserCanLoginWithInvalidPassword(){
        mainPage.loadAPage(mainPage.url);
        mainPage.clickOnElement(mainPage.login_btn);
        login_page.writeOneElement(login_page.userInput,login_page.user_Name);
        login_page.writeOneElement(login_page.password,"selenium");
        login_page.clickOnElement(login_page.checkBox);
        login_page.clickOnElement(login_page.loginBtn);
        Assert.assertEquals(login_page.getElementText(login_page.errorMsg),login_page.errorText);
        Assert.assertTrue(login_page.visibleState(login_page.loginBtn));

    }
    @Test
    public void TestUserCanLoginWithInvalidCredentials(){
        mainPage.loadAPage(mainPage.url);
        mainPage.clickOnElement(mainPage.login_btn);
        login_page.writeOneElement(login_page.userInput,"yru7uieeu");
        login_page.writeOneElement(login_page.password,"jjk89389");
        login_page.clickOnElement(login_page.loginBtn);
//      login_page.getElement(login_page.errorMsg);
        Assert.assertEquals(login_page.getElementText(login_page.errorMsg),login_page.errorText);
        Assert.assertTrue(login_page.visibleState(login_page.loginBtn));
    }


    @Test(dataProvider = "invalidUserCredentials", dataProviderClass = DataSet.class)
    public void TestUserCanLoginWithUserInvalidCredentials(String userName, String pass, String error_massage){
        mainPage.loadAPage(mainPage.url);
        mainPage.clickOnElement(mainPage.login_btn);
        login_page.writeOneElement(login_page.userInput,userName);
        login_page.writeOneElement(login_page.password,pass);
        login_page.clickOnElement(login_page.checkBox);
        login_page.clickOnElement(login_page.loginBtn);
//        mainPage.addScreenShot("Login page after entering name and password");
        Assert.assertEquals(login_page.getElementText(login_page.errorMsg),error_massage);
        Assert.assertTrue(login_page.visibleState(login_page.loginBtn));
//        mainPage.addScreenShot("Login page with error massage");

    }
}