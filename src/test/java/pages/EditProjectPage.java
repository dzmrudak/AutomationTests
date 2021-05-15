package pages;

import core.BrowserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditProjectPage extends AddNewProjectPage {

    private static final String END_POINT = "index.php?/admin/projects/edit/";

    public Logger logger = LogManager.getLogger(EditProjectPage.class);

    // Selectors description
    protected static final By projectIsCompletedBoxBy = By.id("is_completed");

    // Class initialization
    public EditProjectPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            if(getSaveProjectButton().isDisplayed()) {
                logger.info("Edit Project page opened successfully");
                return true;
            } else return false;
        } catch (Exception ex)
        {
            logger.error("Edit Project page has not been opened");
            return false;
        }
    }

    public WebElement getSaveProjectButton() {
        return driver.findElement(acceptProjectButtonBy);
    }
}
