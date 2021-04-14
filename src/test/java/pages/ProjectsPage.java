package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/overview";
    private static final By projectsTabBy = By.id("navigation-sub-projects");

    // Class initialization
    public ProjectsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getProjectsTab().isDisplayed();
        } catch (Exception ex)
        {
            return false;
        }
    }

    // WebElements Methods
    public WebElement getProjectsTab(){
        return driver.findElement(projectsTabBy);
    }

    public String getProjectName(String projectName){
        return driver.findElement(By.partialLinkText(projectName)).getText();
    }

}
