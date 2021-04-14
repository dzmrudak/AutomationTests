package steps;

import core.BrowserService;
import pages.InventoryPage;
import pages.LoginPage;

public class LogOutSteps {
    private BrowserService browserService;

    public LogOutSteps(BrowserService browserService){
        this.browserService = browserService;
    }

    public LoginPage logOut(){
        InventoryPage inventoryPage = new InventoryPage(browserService, false);
        inventoryPage.getMenuButton().isDisplayed();
        inventoryPage.getMenuButton().click();
        inventoryPage.getLogoutLink().isDisplayed();
        inventoryPage.getLogoutLink().click();

        return new LoginPage(browserService, false);
    }
}
