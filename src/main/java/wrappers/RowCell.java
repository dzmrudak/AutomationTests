package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RowCell {

    private UIElement webElement;
    private WebDriver webDriver;

    public RowCell(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.webElement = new UIElement(webDriver, by);
    }

    public RowCell(WebDriver webDriver, WebElement webElement) {
        this.webDriver = webDriver;
        this.webElement = new UIElement(webDriver, webElement);
    }

    public UIElement getElementFromCell(By by) {
        return new UIElement(webDriver, by);
    }
}
