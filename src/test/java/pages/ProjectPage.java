package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {

    private static final String END_POINT = "index.php?/projects/overview/";

    protected static final By editProjectButtonBy = By.className("button-edit");
    protected static final By projectIdBy = By.className("content-header-id");
    protected static final By successMessageBy = By.className("message-success");
    protected static final By testCasesMenuItemBy = By.id("navigation-suites");

    public ProjectPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT + getProjectId().toString());
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getEditButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getEditButton() {
        return driver.findElement(editProjectButtonBy);
    }

    public WebElement getProjectId() {
        return driver.findElement(projectIdBy);
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(successMessageBy);
    }

    public WebElement getTestsCasesMenuItem() {
        return driver.findElement(testCasesMenuItemBy);
    }

}
