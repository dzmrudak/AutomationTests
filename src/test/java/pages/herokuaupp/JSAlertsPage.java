package pages.herokuaupp;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JSAlertsPage extends BasePage {

    private static final String END_POINT = "/javascript_alerts";
    protected static final By jsAlertShowButtonBy = By.xpath("//button[. = 'Click for JS Alert']");
    protected static final By jsAlertConfirmButtonBy = By.xpath("//button[. = 'Click for JS Confirm']");
    protected static final By jsAlertPromptButtonBy = By.xpath("//button[. = 'Click for JS Prompt']");
    protected static final By resultMessageBy = By.id("result");


    public JSAlertsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getJsAlertShowButton().isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public WebElement getJsAlertShowButton() {
        return driver.findElement(jsAlertShowButtonBy);
    }

    public WebElement getJsAlertConfirmButton() {
        return driver.findElement(jsAlertConfirmButtonBy);
    }

    public WebElement getJsAlertPromptButton() {
        return driver.findElement(jsAlertPromptButtonBy);
    }

    public WebElement getResultMessage() {
        return driver.findElement(resultMessageBy);
    }
}
