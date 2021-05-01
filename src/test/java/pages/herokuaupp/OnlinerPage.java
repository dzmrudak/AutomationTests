package pages.herokuaupp;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnlinerPage extends BasePage {

    protected static final By searchInputBy = By.className("fast-search__input");
    protected static final By iFrameSearchInputBy = By.className("search__input");
    protected static final By searchFrameBy = By.className("modal-iframe");
    protected static final By productNameBy = By.xpath("//div[@class = 'product__title']/a");
    protected static final By iFrameCloseSearchWindowButtonBy = By.className("search__close");
    protected static final By footerBy = By.xpath("//div[@class ='footer-style']");
    protected static final By companyInfoLinkBy = By.xpath("//a[contains(text(), 'О компании')]");

    public OnlinerPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://www.onliner.by/");
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSearchInput().isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public WebElement getSearchInput() {
        return driver.findElement(searchInputBy);
    }
    public WebElement getIFrameSearchInput() {
        return driver.findElement(iFrameSearchInputBy);
    }

    public By getSearchFrame() {
        return searchFrameBy;
    }

    public WebElement getProductName() {
        return driver.findElement(productNameBy);
    }

    public By getProductNameBy() {
        return productNameBy;
    }

    public WebElement getIFrameCloseSearchWindowButton() {
        return driver.findElement(iFrameCloseSearchWindowButtonBy);
    }

    public WebElement getFooter() {
        return driver.findElement(footerBy);
    }

    public WebElement getCompanyInfoLink() {
        return driver.findElement(companyInfoLinkBy);
    }


}
