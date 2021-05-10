package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddNewTestCase extends SuiteDetailedPage {

    public Logger logger = LogManager.getLogger(AddNewTestCase.class);

    private static final String END_POINT = "index.php?/cases/add/";

    protected static final By acceptAddingTestCaseButtonBy = By.id("accept");
    protected static final By titleNameInputBy = By.id("title");
    protected static final By selectSectionBy = By.id("section_id");
    protected static final By selectTemplateBy = By.id("template_id");
    protected static final By selectTypeBy = By.id("type_id");
    protected static final By selectPriorityBy = By.id("priority_id");


    public AddNewTestCase(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT + getTestSuiteId().toString().replaceAll("[^\\d.]", ""));
    }

    @Override
    public boolean isPageOpened() {
        try {
            if(getAcceptAddingTestCaseButton().isDisplayed()) {
                logger.info("Add New Test Case page opened successfully");
                return true;
            } else return false;
        } catch (Exception ex) {
            logger.error("Add New Test Case page has not been opened");
            return false;
        }
    }

    public WebElement getAcceptAddingTestCaseButton() {
        return driver.findElement(acceptAddingTestCaseButtonBy);
    }

    public WebElement getTitleNameInput() {
        return driver.findElement(titleNameInputBy);
    }

    public WebElement getSelectSection() {
        return driver.findElement(selectSectionBy);
    }

    public WebElement getSelectTemplate() {
        return driver.findElement(selectTemplateBy);
    }

    public WebElement getSelectType() {
        return driver.findElement(selectTypeBy);
    }

    public WebElement getSelectPriority() {
        return driver.findElement(selectPriorityBy);
    }
}
