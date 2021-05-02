package steps;

import core.BrowserService;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps {

    private BrowserService browserService;

    public LoginSteps(BrowserService browserService){
        this.browserService = browserService;
    }

    public DashboardPage loginWithCorrectCredentials(String email, String psw){
        LoginPage loginPage = new LoginPage(browserService, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLoginButton().click();

        return new DashboardPage(browserService, false);
    }

    public LoginPage loginWithIncorrectCredentials(String email, String psw){
        LoginPage loginPage = new LoginPage(browserService, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLoginButton().click();

        return new LoginPage(browserService, false);
    }
}
