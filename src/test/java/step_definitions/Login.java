package step_definitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.MainPage;

public class Login {
    MainPage mainPage = new MainPage();
    LoginPage login_page = new LoginPage();
    @Given("User should be on the login page")
    public void userShouldBeOnTheLoginPage() {
        mainPage.loadAPage(mainPage.url);
        mainPage.clickOnElement(mainPage.login_btn);
    }

    @When("User enter valid username")
    public void userEnterValidUsername() {
        login_page.writeOneElement(login_page.userInput,login_page.user_Name);
    }

    @And("User enter valid password")
    public void userEnterValidPassword() {
        login_page.writeOneElement(login_page.password,login_page.userPass);
    }

    @And("User click on the remember me check box")
    public void userClickOnTheRememberMeCheckBox() {
        login_page.clickOnElement(login_page.checkBox);
    }
    @And("User click on the login button")
    public void userClickOnTheLoginButton() {
        login_page.clickOnElement(login_page.loginBtn);
    }

    @Then("User should successfully logged in")
    public void userShouldSuccessfullyLoggedIn() {
        Assert.assertEquals(mainPage.getElementText(mainPage.name),login_page.user_Name);
    }

    @But("User should not see the login button")
    public void userShouldNotSeeTheLoginButton() {
        Assert.assertTrue(mainPage.waitForElement(mainPage.user_icon).isDisplayed());
    }
}
