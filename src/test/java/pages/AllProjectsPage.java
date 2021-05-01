package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllProjectsPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/overview";

    private static final By projectsTabBy = By.id("navigation-sub-projects");
    protected static final By successMessageBy = By.className("message-success");
    protected static final String deleteProjectButtonBy = "//td[contains(concat(' ', a, ' '), 'remove')]/a/../following-sibling :: *//div[@class = 'icon-small-delete']";
    protected static final By confirmDeletingBoxBy = By.xpath("//div[@id='deleteDialog']//input[@name='deleteCheckbox']");
    protected static final By confirmDeletingButtonBy = By.xpath("//div[@id='deleteDialog']//a[contains(@class, 'button-ok')]");


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
}
