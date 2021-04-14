package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Selectors description
    protected static final By userNameInputBy = By.id("user-name");
    protected static final By passwordInputBy = By.id("password");
    protected static final By loginButtonBy = By.id("login-button");
    protected static final By loginCredsBy = By.id("login_credentials");
    protected static final By passwordCredsBy = By.className("login_password");


    // Class initialization

    public LoginPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseURL);

    }

    @Override
    public boolean isPageOpened() {
        return getLoginButton().isDisplayed();
    }

    //WebElements Methods

    public WebElement getUserNameInput(){
        return driver.findElement(userNameInputBy);
    }

    public WebElement getPassInput(){
        return driver.findElement(passwordInputBy);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonBy);
    }

    public WebElement getUsernameCreds(){
        return driver.findElement(loginCredsBy);
    }

    public WebElement getPassCreds(){
        return driver.findElement(passwordCredsBy);
    }
}
