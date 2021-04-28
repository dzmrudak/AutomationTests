package pages;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SuiteDetailedPage extends TestCasesPage {

    private static final String END_POINT = "index.php?/suites/view/";

    protected static final By testSuiteIdBy = By.className("content-header-id");

    public SuiteDetailedPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT + getTestSuiteId().toString().replaceAll("[^\\d.]", ""));
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getAddTestCaseButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getTestSuiteId() {
        return driver.findElement(testSuiteIdBy);
    }
}
