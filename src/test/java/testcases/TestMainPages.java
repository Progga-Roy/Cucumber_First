package testcases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.DriverSetUp;

public class TestMainPages extends DriverSetUp {
    MainPage mainPage = new MainPage();
    @Test(description = "Test Main Page Title")
    @Description("Validate Title")
    public void TestMainPageTitle(){
      mainPage.loadAPage(mainPage.url);
      mainPage.addScreenShot("Main page");
      Assert.assertEquals(mainPage.getPageTitle(),mainPage.title);

    }
    @Test(description = "Test Login button")
    @Description("Validate Login button")
    public void LoginButton(){

        mainPage.loadAPage(mainPage.url);
        Assert.assertEquals(mainPage.getElementText(mainPage.login_btn),"log in");
        Assert.assertTrue(mainPage.getElement(mainPage.login_btn).isEnabled());
    }

}
