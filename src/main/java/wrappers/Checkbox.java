package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {

    private UIElement webElement;

    public Checkbox(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
    }

    public void click() {
        webElement.click();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public String getText() {
        return webElement.getText();
    }

}
