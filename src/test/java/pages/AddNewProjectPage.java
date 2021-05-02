package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.RadioButton;

public class AddNewProjectPage extends BasePage {

    private static final String END_POINT = "index.php?/admin/projects/add/1";

    // Selectors description
    protected static final By projectTabBy = By.id("projects-tabs-project");
    protected static final By projectNameInputBy = By.id("name");
    protected static final By announcementsInputBy = By.id("announcement");
    protected static final By showAnnouncementBoxBy = By.id("show_announcement");
    protected static final By projectTypeRadioButtonBy = By.name("suite_mode");
    protected static final By projectType1RadioButtonBy = By.id("suite_mode_single");
    protected static final By projectType2RadioButtonBy = By.id("suite_mode_single_baseline");
    protected static final By projectType3RadioButtonBy = By.id("suite_mode_multi");
    protected static final By acceptProjectButtonBy = By.id("accept");
    protected static final By cancelButtonBy = By.className("button-cancel");

    // Class initialization
    public AddNewProjectPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getAcceptProjectButton().isDisplayed();
        } catch (Exception ex)
        {
            return false;
        }
    }

    // WebElements Methods
    public WebElement getProjectTab() {
        return driver.findElement(projectTabBy);
    }
    public WebElement getProjectNameInput() {
        return driver.findElement(projectNameInputBy);
    }
    public WebElement getAnnouncementInput() {
        return driver.findElement(announcementsInputBy);
    }
    public Checkbox getAnnouncementBox() {
        return new Checkbox(driver, showAnnouncementBoxBy);
    }

    public RadioButton getProjectTypeRadioButton() {
        return new RadioButton(driver, projectTypeRadioButtonBy);
    }

    public WebElement getProjectType1RadioButton() {
        return driver.findElement(projectType1RadioButtonBy);
    }
    public WebElement getProjectType2RadioButton() {
        return driver.findElement(projectType2RadioButtonBy);
    }
    public WebElement getProjectType3RadioButton() {
        return driver.findElement(projectType3RadioButtonBy);
    }
    public Button getAcceptProjectButton() {
        return new Button(driver, acceptProjectButtonBy);
    }
    public Button getCancelProjectButton() {
        return new Button(driver, cancelButtonBy);
    }

}
