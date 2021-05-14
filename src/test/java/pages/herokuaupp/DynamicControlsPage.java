package pages.herokuaupp;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicControlsPage extends BasePage {

    private static final String END_POINT = "/dynamic_controls";
    protected static final By checkboxBoxBy = By.id("checkbox");
    protected static final By removeButtonBy = By.xpath("//button[. = 'Remove']");
    private static final By successMessageCheckBoxBy = By.xpath("//*[@id = 'checkbox-example']//*[@id = 'message']");
    protected static final By enableInputButtonBy = By.xpath("//*[@id = 'input-example']/button");
    protected static final By inputBy = By.xpath("//*[@id = 'input-example']/input");
    private static final By successMessageInputBy = By.xpath("//*[@id = 'input-example']//*[@id = 'message']");


    public DynamicControlsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getCheckboxBox().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getCheckboxBox() {
        return driver.findElement(checkboxBoxBy);
    }

    public List<WebElement> getAllCheckboxes() {
        return driver.findElements(checkboxBoxBy);
    }

    public WebElement getRemoveButton() {
        return driver.findElement(removeButtonBy);
    }

    public WebElement getSuccessMessageCheckBox() {
        return driver.findElement(successMessageCheckBoxBy);
    }

    public By getSuccessMessageText() {
        return successMessageCheckBoxBy;
    }

    public WebElement getEnableInputButton() {
        return driver.findElement(enableInputButtonBy);
    }

    public WebElement getInput() {
        return driver.findElement(inputBy);
    }

    public By getSuccessMessageInputText() {
        return successMessageInputBy;
    }

    public WebElement getSuccessMessageInput() {
        return driver.findElement(successMessageInputBy);
    }
}
