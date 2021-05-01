package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.herokuaupp.ContextMenuPage;
import pages.herokuaupp.DynamicControlsPage;
import pages.herokuaupp.FileUploadPage;
import pages.herokuaupp.HerokuauppMainPage;
import steps.LoginSteps;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SmokeTest2 extends BaseTest {

    @Test
    public void waitTest() {
        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        WebElement element = waits.waitForVisibility(By.id("sidebar-projects-add"));
        WebElement element1 = waits.waitForVisibility(new DashboardPage(browserService, false).getSidebarProjectsAddButton());

        Assert.assertTrue(element.isDisplayed());

        browserService.getDriver().navigate().refresh();

        Wait<WebDriver> fluent = new FluentWait<>(browserService.getDriver())
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(20, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement fluentElement = fluent.until(driver -> driver.findElement(By.id("sidebar-projects-add")));
        Assert.assertTrue(fluentElement.isDisplayed());

        browserService.getDriver().navigate().refresh();

        WebElement fluentElement1 = fluent.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidebar-projects-add")));
        Assert.assertTrue(fluentElement1.isDisplayed());

    }

    @Test
    public void actionContextMenuTest() {
        //Context Menu
        //Реализовать Правый клик по элементу

        HerokuauppMainPage contextMenu = new HerokuauppMainPage(browserService, true);
        contextMenu.getContextMenuButton().click();

        ContextMenuPage contextMenuPage = new ContextMenuPage(browserService, false);
        WebElement element = waits.waitForVisibility(contextMenuPage.getContextMenuFrame());
        Actions actions = new Actions(browserService.getDriver());
        actions
                .moveToElement(element)
                .contextClick()
                .build()
                .perform();

        Alert alert = browserService.getDriver().switchTo().alert();

        Assert.assertEquals(alert.getText(), "You selected a context menu");

    }

    @Test
    public void actionDynamicControlsTest() {
        //Dynamic Controls

        HerokuauppMainPage contextMenu = new HerokuauppMainPage(browserService, true);
        contextMenu.getDynamicControlsButton().click();

        // 1. Найти чекбокс
        DynamicControlsPage dynamicControls = new DynamicControlsPage(browserService, false);
        waits.waitForVisibility(dynamicControls.getCheckboxBox());
        dynamicControls.getCheckboxBox().click();

        // 2. Нажать на кнопку
        dynamicControls.getRemoveButton().click();

        // 3. Дождаться надписи “It’s gone”
        waits.waitForVisibility(dynamicControls.getSuccessMessageText());
        Assert.assertEquals(dynamicControls.getSuccessMessageCheckBox().getText(), "It's gone!");

        // 4. Проверить, что чекбокса нет
        Assert.assertFalse(dynamicControls.getAllCheckboxes().size() > 0);

        // 5. Найти инпут
        // 6. Проверить, что он disabled
        Assert.assertFalse(dynamicControls.getInput().isEnabled());

        // 7. Нажать на кнопку
        dynamicControls.getEnableInputButton().click();

        // 8. Дождаться надписи “It's enabled!”
        waits.waitForVisibility(dynamicControls.getSuccessMessageInputText());
        Assert.assertEquals(dynamicControls.getSuccessMessageInput().getText(), "It's enabled!");

        // 9. Проверить, что инпут enabled
        Assert.assertTrue(dynamicControls.getInput().isEnabled());
    }

    @Test
    public void actionFileUploadTest() {
//        Загрузить файл. Для относительного пути использовать
//        https://stackoverflow.com/questions/45612089/how-to-upload-file-with-relative-path-in-selenium-webdriver
//        Проверить, что имя файла на странице совпадает с именем загруженного файла

        Actions actions = new Actions(browserService.getDriver());
        HerokuauppMainPage contextMenu = new HerokuauppMainPage(browserService, true);
        contextMenu.getFileUploadButton().click();

        FileUploadPage fileUpload = new FileUploadPage(browserService, false);
        String fileName = "vacation.png";
        String filepath = System.getProperty("user.dir") + "\\" + fileName;

        fileUpload.getUploadButton().sendKeys(filepath);

        Assert.assertEquals(fileUpload.getUploadButton().getAttribute("value"), "C:\\fakepath\\" + fileName);
    }
}
