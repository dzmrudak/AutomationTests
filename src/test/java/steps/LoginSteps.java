package steps;

import core.BrowserService;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginSteps {

    private BrowserService browserService;

    public LoginSteps(BrowserService browserService){
        this.browserService = browserService;
    }

    public InventoryPage loginWithCorrectCreds(String login, String pass){
        LoginPage loginPage = new LoginPage(browserService, true);
        loginPage.getUsernameCreds().isDisplayed();
        loginPage.getPassCreds().isDisplayed();
        loginPage.getUserNameInput().sendKeys(login);
        loginPage.getPassInput().sendKeys(pass);
        loginPage.getLoginButton().click();

        return new InventoryPage(browserService, false);
    }
}
