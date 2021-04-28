package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestCasesPage extends ProjectPage {

    private static final String END_POINT = "index.php?/suites/view/";

    protected static final By addTestCaseButtonBy = By.id("sidebar-cases-add");
    protected String testCaseLinkNameBy = "//a[contains(concat(' ',span,' '), ' remove ')]";
    protected static final String editTestCaseButtonBy = "//*[contains(concat(' ',span,' '), ' remove ')]/../following-sibling :: *//a[@class = 'editLink']";
    protected static final String deleteTestCaseButtonBy = "//*[contains(concat(' ',span,' '), ' remove ')]/../following-sibling :: *//a[@class = 'deleteLink']";
    protected static final By deleteTestCasePermanentlyButtonBy = By.xpath("//div[@id='dialog-ident-casesDeletionDialog']//a[contains(text(),\"Delete Permanently\")]");
    protected static final By confirmDeleteTestCasePermanentlyButtonBy =
            By.xpath("//div[@id='dialog-ident-casesDeletionConfirmationDialog']//a[contains(text(),\"Delete Permanently\")]");

    public TestCasesPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT + getProjectId().toString());
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getAddTestCaseButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getAddTestCaseButton() {
        return driver.findElement(addTestCaseButtonBy);
    }
    public List<WebElement> getTestCaseLinkName(String testCaseName) {
        return driver.findElements(By.xpath(testCaseLinkNameBy.replace("remove", testCaseName)));
    }
    public WebElement getEditTestCaseButton(String testCaseName) {
        return driver.findElement(By.xpath(editTestCaseButtonBy.replace("remove", testCaseName)));
    }
    public WebElement getDeleteTestCaseButton(String testCaseName) {
        return driver.findElement(By.xpath(deleteTestCaseButtonBy.replace("remove", testCaseName)));
    }
    public WebElement getDeleteTestCasePermanentlyButton() {
        return driver.findElement(deleteTestCasePermanentlyButtonBy);
    }
    public WebElement getConfirmDeleteTestCasePermanentlyButton() {
        return driver.findElement(confirmDeleteTestCasePermanentlyButtonBy);
    }
}
