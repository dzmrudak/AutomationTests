package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemDetailedPage extends BasePage {

    private static final String END_POINT = "inventory-item.html?id= ";
    public int itemId;

    //Page Selectors
    protected static final By backToProductsButtonBy = By.id("back-to-products");

    public ItemDetailedPage(BrowserService browserService, boolean openPageByUrl, int itemId) {
        super(browserService, openPageByUrl);
        this.itemId = itemId;
    }

    @Override
    protected void openPage() {
        driver.get(baseURL + END_POINT + itemId);
    }


    @Override
    public boolean isPageOpened() {
        try {
            return getBackToProductsButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }    }

    public WebElement getBackToProductsButton(){
        return driver.findElement(backToProductsButtonBy);
    }

}
