package pages;

import baseEntities.BasePage;
import core.BrowserService;
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.DropDownMenu;

public class DashboardPage extends BasePage {

    private static String END_POINT = "index.php?/dashboard";

    public Logger logger = LogManager.getLogger(DashboardPage.class);

    protected static final By sidebarProjectsAddButtonBy = By.id("sidebar-projects-add");
    protected String projectNameTitleBy = "remove";
    protected static final By administrationButtonBy = By.id("navigation-admin");
    protected static final By navigationUserDropDownBy = By.id("navigation-user");
    protected static final By navigationMenuDropDownBy = By.id("navigation-menu");
    protected static final By navigationUserDropDownMenuBy = By.xpath("//*[@class= 'top-menu-item']/following :: " +
            "div[@id= 'userDropdown']//*[@class = 'dropdown-menu-link']");

    protected static final By navigationMenuDropDownMenuBy = By.xpath("//*[@class= 'top-menu-item']/following :: " +
            "div[@id= 'helpDropdown']//*[@class = 'dropdown-menu-link']");

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
            if(getSidebarProjectsAddButton().isDisplayed()) {
                logger.info("Dashboard page opened successfully");
                return true;
            } else return false;
        } catch (Exception ex)
        {
            logger.error("Dashboard page has not been opened");
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

    public WebElement getNavigationUserDropDown(){
        return driver.findElement(navigationUserDropDownBy);
    }

    public WebElement getNavigationMenuDropDown(){
        return driver.findElement(navigationMenuDropDownBy);
    }

    public DropDownMenu getNavigationUserDropDownMenu() {
        return new DropDownMenu(driver, navigationUserDropDownMenuBy);
    }

    public DropDownMenu getNavigationMenuDropDownMenu() {
        return new DropDownMenu(driver, navigationMenuDropDownMenuBy);
    }

}
