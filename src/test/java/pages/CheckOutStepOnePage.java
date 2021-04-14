package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckOutStepOnePage extends BasePage {

    private static final String END_POINT = "checkout-step-one.html";

    protected static final By continueButtonBy = By.id("continue");
    protected static final By firstNameInputBy = By.id("first-name");
    protected static final By lastNameInputBy = By.id("last-name");
    protected static final By zipCodeInputBy = By.id("postal-code");

    public CheckOutStepOnePage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseURL + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getContinueButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButtonBy);
    }
    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInputBy);
    }
    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInputBy);
    }
    public WebElement getZipCodeInput() {
        return driver.findElement(zipCodeInputBy);
    }



}
