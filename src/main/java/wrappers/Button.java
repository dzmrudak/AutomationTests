package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Waits;

public class Button {

    private UIElement webElement;

    public Button(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
    }

    public void click() {
        webElement.click();
    }

    public void submit() {
        webElement.submit();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public void hover() {
        webElement.hover();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }

}
