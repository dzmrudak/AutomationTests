package pages.herokuaupp;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFramePage extends BasePage {

    private static final String END_POINT = "/iframe";
    protected static final By iFrameBy = By.xpath("//iframe");
    protected static final By iFrameTextInputBy = By.xpath("//p");
    protected static final By alignCenterButtonBy = By.xpath("//button[@title = 'Align center']");

    public IFramePage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getIFrame().isDisplayed();
        } catch (Exception exception) {
            return false;
        }    }

    public WebElement getIFrame() {
        return driver.findElement(iFrameBy);
    }

    public WebElement getIFrameTextInput() {
        return driver.findElement(iFrameTextInputBy);
    }

    public WebElement getAlignCenterButton() {
        return driver.findElement(alignCenterButtonBy);
    }
}
