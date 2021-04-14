package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private static final String END_POINT = "inventory.html";

    // Common page selectors description
    protected static final By inventoryListBy = By.className("inventory_list");
    protected static final By titleNameBy = By.className("title");
    protected static final By menuButtonBy = By.id("react-burger-menu-btn");
    protected static final By allItemsLinkBy = By.id("inventory_sidebar_link");
    protected static final By aboutLinkBy = By.id("about_sidebar_link");
    protected static final By logoutLinkBy = By.id("logout_sidebar_link");
    protected static final By resetAppStateBy = By.id("reset_sidebar_link");


    protected static final By shoppingCartButtonBy = By.className("shopping_cart_link");
    protected static final By shoppingCartButtonBadgeBy = By.className("shopping_cart_badge");
    protected static final By sortingDropDownBy = By.className("product_sort_container");
    protected static final By twitterIconBy = By.className("social_twitter");
    protected static final By facebookIconBy = By.className("social_facebook");
    protected static final By linkedinIconBy = By.className("social_linkedin");
    // Item unit selectors description
    protected static final By itemContainerBy = By.className("inventory_item");
    protected static final By itemLinkNameBy = By.className("inventory_item_name");
    protected static final By itemDescriptionBy = By.className("inventory_item_desc");
    protected static final By itemPriceBy = By.className("inventory_item_price");
    protected static final By itemImgLinkBy = By.className("inventory_item_img");
    protected static final By itemAddToCartButtonBy = By.className("btn_inventory");

    // Class initialization

    public InventoryPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseURL + END_POINT);

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getInventoryList().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    // WebElements Methods

    public WebElement getInventoryList() {
        return driver.findElement(inventoryListBy);
    }

    public String getInventoryTitle(){
        return driver.findElement(titleNameBy).getText();
    }

    public WebElement getMenuButton(){
        return driver.findElement(menuButtonBy);
    }

    public WebElement getAllItemsLink(){
        return driver.findElement(allItemsLinkBy);
    }

    public WebElement getAboutLink(){
        return driver.findElement(aboutLinkBy);
    }

    public WebElement getLogoutLink(){
        return driver.findElement(logoutLinkBy);
    }

    public WebElement getResetAppStateLink(){
        return driver.findElement(resetAppStateBy);
    }

    public WebElement getShoppingCartButton(){
        return driver.findElement(shoppingCartButtonBy);
    }

    public WebElement getShoppingCartButtonBadge(){
        return driver.findElement(shoppingCartButtonBadgeBy);
    }

    public WebElement getSortingDropDown(){
        return driver.findElement(sortingDropDownBy);
    }

    public WebElement getTwitterIcon(){
        return driver.findElement(twitterIconBy);
    }

    public WebElement getFacebookIcon(){
        return driver.findElement(facebookIconBy);
    }

    public WebElement getLinkedinIcon(){
        return driver.findElement(linkedinIconBy);
    }

    public List<InventoryItem> getAllItems(){
        return driver.findElements(itemContainerBy).stream()
                .map(el -> new InventoryItem(
                        el.findElement(itemLinkNameBy),
                        el.findElement(itemDescriptionBy),
                        el.findElement(itemPriceBy),
                        el.findElement(itemImgLinkBy),
                        el.findElement(itemAddToCartButtonBy)))
                .collect(Collectors.toList());
    }

}
