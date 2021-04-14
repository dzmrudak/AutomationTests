package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected static final int WAIT_FOR_OPEN_PAGE_LOAD_IN_SECONDS = 5;
    public WebDriver driver;
    private BrowserService browserService;
    public String baseURL;

    protected abstract void openPage();
    public abstract boolean isPageOpened();

    public BasePage(BrowserService browserService, boolean openPageByUrl){
        this.browserService = browserService;
        this.driver = browserService.getDriver();
        this.baseURL = new ReadProperties().getURL();

        if(openPageByUrl){
            openPage();
        }

        waitForOpen();
    }

    protected void waitForOpen(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while(!isPageOpenedIndicator && secondsCount < WAIT_FOR_OPEN_PAGE_LOAD_IN_SECONDS){
            browserService.sleep(1000);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if(!isPageOpenedIndicator){
            throw new AssertionError("Page is not opened");
        }
    }

}
