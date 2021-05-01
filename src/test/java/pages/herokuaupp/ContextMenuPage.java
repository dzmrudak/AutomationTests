package pages.herokuaupp;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContextMenuPage extends BasePage {

    private static final String END_POINT = "/context_menu";
    protected static final By contextMenuFrameBy = By.id("hot-spot");

    public ContextMenuPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getContextMenuFrame().isDisplayed();
        } catch (Exception ex) {
            return false;
        }    }

    public WebElement getContextMenuFrame() {
        return driver.findElement(contextMenuFrameBy);
    }
}
