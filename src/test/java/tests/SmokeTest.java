package tests;

import core.BrowserService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.CheckOutSteps;
import steps.LogOutSteps;
import steps.LoginSteps;

import java.util.List;

public class SmokeTest {

    @Test
    public void LoginTest(){

        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        InventoryPage inventoryPage = loginSteps.loginWithCorrectCreds("standard_user", "secret_sauce");

        Assert.assertEquals(inventoryPage.getInventoryTitle(), "PRODUCTS");

        driver.quit();
    }

    @Test
    public void logoutTest(){
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        LogOutSteps logOutSteps = new LogOutSteps(browserService);
        loginSteps.loginWithCorrectCreds("standard_user", "secret_sauce");
        LoginPage logOut = logOutSteps.logOut();

        Assert.assertTrue(logOut.isPageOpened());
        driver.quit();
    }

    @Test
    public void addAllItemsToCart(){
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        InventoryPage inventoryPage = loginSteps.loginWithCorrectCreds("standard_user", "secret_sauce");
        List<InventoryItem> itemsInCart = inventoryPage.getAllItems();

        for(InventoryItem item: itemsInCart){
            item.getAddToCartButton().click();
        }

        Assert.assertEquals(itemsInCart.size(), Integer.parseInt(inventoryPage.getShoppingCartButtonBadge().getText()));

        driver.quit();
    }

    @Test
    public void doPurchaseOfAllItems(){
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        LoginSteps loginSteps = new LoginSteps(browserService);
        InventoryPage inventoryPage = loginSteps.loginWithCorrectCreds("standard_user", "secret_sauce");
        List<InventoryItem> itemsInCart = inventoryPage.getAllItems();

        for(InventoryItem item: itemsInCart){
            item.getAddToCartButton().click();
        }

        Assert.assertEquals(itemsInCart.size(), Integer.parseInt(inventoryPage.getShoppingCartButtonBadge().getText()));
        inventoryPage.getShoppingCartButton().click();

        CheckOutSteps checkOutSteps = new CheckOutSteps(browserService);
        CheckOutCompletePage checkOutCompletePage = checkOutSteps.checkOutComplete("dzmitry", "rudak", "93-575");
        Assert.assertEquals(checkOutCompletePage.getTitle().getText(), "CHECKOUT: COMPLETE!");

        driver.quit();
    }
}
