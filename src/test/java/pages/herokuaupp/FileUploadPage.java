package pages.herokuaupp;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadPage extends BasePage {

    private static final String END_POINT = "/upload";
    protected static final By fileUploadSubmitButtonBy = By.id("file-submit");
    protected static final By fileUploadButtonBy = By.xpath("//*[@id = 'file-upload']");
    //protected static final By dragNDropFrameBy = By.id("drag-drop-upload");




    public FileUploadPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getUploadButton().isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public WebElement getUploadButton() {
        return driver.findElement(fileUploadButtonBy);
    }

    public WebElement getUploadSubmitButton()  {
        return driver.findElement(fileUploadSubmitButtonBy);
    }
}
