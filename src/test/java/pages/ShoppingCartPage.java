package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static pages.InventoryPage.*;

public class ShoppingCartPage extends BasePage {

    private static final String END_POINT = "cart.html";

    // Selectors description

    protected static final By continueShoppingButtonBy = By.id("continue-shopping");
    protected static final By checkoutButtonBy = By.id("checkout");
    protected static final By cartQuantityLabelBy = By.className("cart_quantity_label");
    protected static final By cartDescriptionLabelBy = By.className("cart_desc_label");
    protected static final By cartListBy = By.className("cart_list");

    protected static final By quantityAmountItemBy = By.className("cart_quantity");
    protected static final By removeItemButtonBy = By.className("cart_button");

    // Class initialization

    public ShoppingCartPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseURL + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getCheckoutButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    // WebElements methods
    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButtonBy);
    }
    public WebElement getContinueShoppingButton() {
        return driver.findElement(continueShoppingButtonBy);
    }
    public WebElement getCartQuantityLabel() {
        return driver.findElement(cartQuantityLabelBy);
    }
    public WebElement getCartDescriptionLabel() {
        return driver.findElement(cartDescriptionLabelBy);
    }

    public List<InventoryItem> getAllItemsInCart(){
        return driver.findElements(cartListBy).stream()
                .map(el -> new InventoryItem(
                        el.findElement(itemLinkNameBy),
                        el.findElement(itemDescriptionBy),
                        el.findElement(itemPriceBy),
                        el.findElement(itemImgLinkBy),
                        el.findElement(itemAddToCartButtonBy),
                        el.findElement(quantityAmountItemBy),
                        el.findElement(removeItemButtonBy)))
                .collect(Collectors.toList());
    }

}
