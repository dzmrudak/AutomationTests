package pages.herokuaupp;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HerokuauppMainPage extends BasePage {

    protected static final By headerTitleBy = By.className("heading");
    protected static final By contextMenuButtonBy = By.xpath("//li[contains(concat(' ', a, ' '), ' Context Menu ')]/a");
    protected static final By dynamicControlsButtonBy = By.xpath("//li[contains(concat(' ', a, ' '), ' Dynamic Controls ')]/a");
    protected static final By fileUploadButtonBy = By.xpath("//li[contains(concat(' ', a, ' '), ' File Upload ')]/a");

    public HerokuauppMainPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getHeaderTitle().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleBy);
    }

    public WebElement getContextMenuButton() {
        return driver.findElement(contextMenuButtonBy);
    }

    public WebElement getDynamicControlsButton() {
        return driver.findElement(dynamicControlsButtonBy);
    }

    public WebElement getFileUploadButton() {
        return driver.findElement(fileUploadButtonBy);
    }
}
