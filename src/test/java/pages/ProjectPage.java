package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {

    private static final String END_POINT = "index.php?/projects/overview/";

    public static Logger logger = LogManager.getLogger(ProjectPage.class);

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
            if(getEditButton().isDisplayed()) {
                logger.info("Project Page opened successfully");
                return true;
            } else return false;
        } catch (Exception ex) {
            logger.error("Project Page has not been opened.");
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
