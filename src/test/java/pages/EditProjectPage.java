package pages;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditProjectPage extends AddNewProjectPage {

    private static final String END_POINT = "index.php?/admin/projects/edit/";

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
            return getSaveProjectButton().isDisplayed();
        } catch (Exception ex)
        {
            return false;
        }
    }

    public WebElement getSaveProjectButton() {
        return driver.findElement(addProjectButtonBy);
    }




}
