package pages;

import org.openqa.selenium.WebElement;

public class InventoryItem{

    public WebElement linkName;
    public WebElement description;
    public WebElement price;
    public WebElement img;
    public WebElement addToCartButton;
    public WebElement quantityAmount;
    public WebElement removeButton;

    public InventoryItem(WebElement linkName, WebElement description, WebElement price, WebElement img,
                         WebElement addToCartButton) {
        this.linkName = linkName;
        this.description = description;
        this.price = price;
        this.img = img;
        this.addToCartButton = addToCartButton;
    }

    public InventoryItem(WebElement linkName, WebElement description, WebElement price, WebElement img,
                         WebElement addToCartButton, WebElement quantityAmount, WebElement removeButton) {
        this.linkName = linkName;
        this.description = description;
        this.price = price;
        this.img = img;
        this.addToCartButton = addToCartButton;
        this.quantityAmount = quantityAmount;
        this.removeButton = removeButton;
    }

    public WebElement getLinkName() {
        return linkName;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getImg() {
        return img;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getQuantityAmount() {
        return quantityAmount;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

}
