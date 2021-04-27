package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCaseDetailedPage extends BasePage {

    private static final String END_POINT = "index.php?/cases/view/";

    protected static final By testCaseIdBy = By.className("content-header-id");
    protected static final By successMessageBy = By.className("message-success");
    protected static final By editTestCaseButtonBy = By.className("button-edit");

    public TestCaseDetailedPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getEditTestCaseButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getTestCaseId() {
        return driver.findElement(testCaseIdBy);
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(successMessageBy);
    }

    public WebElement getEditTestCaseButton() {
        return driver.findElement(editTestCaseButtonBy);
    }

}
