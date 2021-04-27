package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuitesPage extends ProjectPage {

    private static final String END_POINT = "index.php?/suites/overview/";

    protected static final By addTestSuiteButtonBy = By.id("navigation-suites-add");
    protected static final String suiteNameBy = "//*[contains(concat(' ', a, ' '), ' remove ')]/a";


    public SuitesPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT + getProjectId().toString());
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getAddTestSuiteButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getAddTestSuiteButton() {
        return driver.findElement(addTestSuiteButtonBy);
    }

    public WebElement getSuiteName(String suiteName) {
        return driver.findElement(By.xpath(suiteNameBy.replace("remove", suiteName)));
    }
}
