package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Table;

public class AllProjectsPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/overview";

    public Logger logger = LogManager.getLogger(AllProjectsPage.class);

    private static final By projectsTabBy = By.id("navigation-sub-projects");
    protected static final By successMessageBy = By.className("message-success");
    protected static final String deleteProjectButtonBy = "//td[contains(concat(' ', a, ' '), 'remove')]/a/../following-sibling :: *//div[@class = 'icon-small-delete']";
    protected static final By confirmDeletingBoxBy = By.xpath("//div[@id='deleteDialog']//input[@name='deleteCheckbox']");
    protected static final By confirmDeletingButtonBy = By.xpath("//div[@id='deleteDialog']//a[contains(@class, 'button-ok')]");
    protected static final By tableBy = By.className("grid");

    // Class initialization
    public AllProjectsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            if(getProjectsTab().isDisplayed()) {
                logger.info("Add New Test Case page opened successfully");
                return true;
            } else return false;
        } catch (Exception ex)
        {
            logger.error("Projects page has not been opened");
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

    public WebElement getSuccessMessage() {
        return driver.findElement(successMessageBy);
    }

    public WebElement getDeleteProjectButton(String projectName) {
        return driver.findElement(By.xpath(deleteProjectButtonBy.replace("remove", projectName)));
    }

    public WebElement getConfirmDeletingBox() {
        return driver.findElement(confirmDeletingBoxBy);
    }

    public WebElement getConfirmDeletingProjectButton(){
        return driver.findElement(confirmDeletingButtonBy);
    }

    public Table projectTable = new Table(driver, tableBy);
}
