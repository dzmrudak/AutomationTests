package steps;

import core.BrowserService;
import pages.CheckOutCompletePage;
import pages.CheckOutStepOnePage;
import pages.CheckOutStepTwoPage;
import pages.ShoppingCartPage;


public class CheckOutSteps {
    private BrowserService browserService;

    public CheckOutSteps(BrowserService browserService){
        this.browserService = browserService;
    }

    public CheckOutStepTwoPage checkOutStepOne(String firstName, String lastName, String zipCode){
        CheckOutStepOnePage checkOutSteps = new CheckOutStepOnePage(browserService, false);
        checkOutSteps.getFirstNameInput().sendKeys(firstName);
        checkOutSteps.getLastNameInput().sendKeys(lastName);
        checkOutSteps.getZipCodeInput().sendKeys(zipCode);
        checkOutSteps.getContinueButton().click();

        return new CheckOutStepTwoPage(browserService, false);
    }

    public CheckOutCompletePage checkOutComplete(String firstName, String lastName, String zipCode){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(browserService, false);
        shoppingCartPage.getCheckoutButton().isDisplayed();
        shoppingCartPage.getCheckoutButton().click();
        CheckOutStepOnePage checkOutSteps = new CheckOutStepOnePage(browserService, false);
        checkOutSteps.getFirstNameInput().sendKeys(firstName);
        checkOutSteps.getLastNameInput().sendKeys(lastName);
        checkOutSteps.getZipCodeInput().sendKeys(zipCode);
        checkOutSteps.getContinueButton().click();
        CheckOutStepTwoPage checkOutStepTwoPage = new CheckOutStepTwoPage(browserService, false);
        checkOutStepTwoPage.getFinishButton().click();

        return new CheckOutCompletePage(browserService, false);
    }
}
