package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckOutCompletePage extends BasePage {

    private static final String END_POINT = "checkout-complete.html";

    protected static final By backHomeButtonBy = By.id("back-to-products");
    protected static final By checkOutCompleteTitleBy = By.className("title");

    public CheckOutCompletePage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseURL + END_POINT);
    }


    @Override
    public boolean isPageOpened() {
        try {
            return getBackHomeButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButtonBy);
    }
    public WebElement getTitle() {
        return driver.findElement(checkOutCompleteTitleBy);
    }

}
