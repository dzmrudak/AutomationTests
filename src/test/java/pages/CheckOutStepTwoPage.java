package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckOutStepTwoPage extends BasePage {

    private static final String END_POINT = "checkout-step-two.html";

    protected static final By finishButtonBy = By.id("finish");

    public CheckOutStepTwoPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseURL + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getFinishButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonBy);
    }
}
