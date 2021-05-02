package pages;

import baseEntities.BasePage;
import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;

public class LoginPage extends BasePage {

    // Selectors description
    protected static final By emailInputBy = By.id("name");
    protected static final By passwordInputBy = By.id("password");
    protected static final By loginButtonBy = By.id("button_primary");
    protected static final By errorLabelBy = By.className("error-text");

    // Class initialization
    public LoginPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getLoginButton().isDisplayed();
        } catch (Exception ex)
        {
            return false;
        }

    }

    // WebElements Methods
    public WebElement getEmailInput() {
        return driver.findElement(emailInputBy);
    }
    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputBy);
    }
    public Button getLoginButton() {
        return new Button(driver, loginButtonBy);
    }
    public String getErrorText() {
        return driver.findElement(errorLabelBy).getText();
    }

}
