package pages;

import baseEntities.BasePage;
import core.BrowserService;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private static String END_POINT = "index.php?/dashboard";

    protected static final By sidebarProjectsAddButtonBy = By.id("sidebar-projects-add");
    protected String projectNameTitleBy = "remove";
    protected static final By administrationButtonBy = By.id("navigation-admin");

    // Class initialization
    public DashboardPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSidebarProjectsAddButton().isDisplayed();
        } catch (Exception ex)
        {
            return false;
        }
    }

    // WebElements Methods
    public WebElement getSidebarProjectsAddButton() {
        return driver.findElement(sidebarProjectsAddButtonBy);
    }

    public WebElement getProjectNameTitle(String projectName){
        return driver.findElement(By.partialLinkText(projectNameTitleBy.replace("remove", projectName)));
    }

    public WebElement getAdministrationButton(){
        return driver.findElement(administrationButtonBy);
    }

}
