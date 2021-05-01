package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.herokuaupp.*;
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

        HerokuauppMainPage dynamicControlPage = new HerokuauppMainPage(browserService, true);
        dynamicControlPage.getDynamicControlsButton().click();

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
        HerokuauppMainPage fileUploadPage = new HerokuauppMainPage(browserService, true);
        fileUploadPage.getFileUploadButton().click();

        FileUploadPage fileUpload = new FileUploadPage(browserService, false);
        String fileName = "vacation.png";
        String filepath = System.getProperty("user.dir") + "\\" + fileName;

        fileUpload.getUploadButton().sendKeys(filepath);

        Assert.assertEquals(fileUpload.getUploadButton().getAttribute("value"), "C:\\fakepath\\" + fileName);
    }

    @Test
    public void actionAlertsTest() {
        //Alerts

        HerokuauppMainPage jsAlerts = new HerokuauppMainPage(browserService, true);

        // Открыть страницу Alerts (http://the-internet.herokuapp.com/javascript_alerts)
        jsAlerts.getJsAlertsButton().click();
        JSAlertsPage jsAlertsPage = new JSAlertsPage(browserService, false);

        // Кликнуть по кнопке Click for JS Alert
        jsAlertsPage.getJsAlertShowButton().click();
        Alert alert = browserService.getDriver().switchTo().alert();
        String alertInput = "Hi! How are you?";

        // Принять Alert
        alert.accept();

        // Проверить статус - принято
        Assert.assertEquals(jsAlertsPage.getResultMessage().getText(), "You successfully clicked an alert");

        // Кликнуть по кнопке Click for JS Confirm
        jsAlertsPage.getJsAlertConfirmButton().click();

        // Отказать в Alert-е
        alert.dismiss();

        // Проверить что статус - Отказано
        Assert.assertEquals(jsAlertsPage.getResultMessage().getText(), "You clicked: Cancel");

        // Кликнуть по кнопке Click for JS Prompt
        jsAlertsPage.getJsAlertPromptButton().click();

        // Ввести текст
        alert.sendKeys(alertInput);

        // Принять Alert
        alert.accept();

        // Проверить что статус содержит введенный текст
        Assert.assertEquals(jsAlertsPage.getResultMessage().getText(), "You entered: " + alertInput);
    }

    @Test
    public void actionIFrameTest() {
        //iFrames

        //Открыть страницу iFames (http://the-internet.herokuapp.com/iframe)
        IFramePage iFramePage = new IFramePage(browserService, true);
        String iFrameInput = "Hi! How are you?";

        //Перейти в iFrame
        browserService.getDriver().switchTo().frame(iFramePage.getIFrame());

        // Очистка поля от тектса по умолчанию
        Actions actions = new Actions(browserService.getDriver());
        actions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build()
                .perform();

        //В поле ввода ввести некоторый текст
        iFramePage.getIFrameTextInput().sendKeys(iFrameInput);

        //Перейти в родительский фрейм и выбрать выравнивание по центру
        browserService.getDriver().switchTo().parentFrame();
        iFramePage.getAlignCenterButton().click();

        // Проверка на применение стиля к тексту
        browserService.getDriver().switchTo().frame(iFramePage.getIFrame());
        Assert.assertEquals(iFramePage.getIFrameTextInput().getAttribute("style"), "text-align: center;");
    }

    @Test
    public void actionIFrameTest2() {
        //iFrames

        // Открыть Onliner.by
        OnlinerPage onlinerPage = new OnlinerPage(browserService, true);
        Actions actions = new Actions(browserService.getDriver());

        // В строке поиска ввести какое-то значение для поиска
        onlinerPage.getSearchInput().click();
        onlinerPage.getSearchInput().sendKeys("macbook");

        // Дождаться появление iFrame
        // Переключиться в iFrame
        waits.waitForVisibilityOfFrame(onlinerPage.getSearchFrame());
        waits.waitForVisibility(onlinerPage.getProductNameBy());

        // Взять название первого элемента из списка
        String productName = onlinerPage.getProductName().getText();

        // Удалить поисковое значение и ввести полученное на шаге 5
        onlinerPage.getIFrameSearchInput().click();
        actions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        onlinerPage.getIFrameSearchInput().sendKeys(productName);

        //Закрыть окно поиска
        onlinerPage.getIFrameCloseSearchWindowButton().click();
        browserService.getDriver().switchTo().defaultContent();

        // Проверить что искомый предмет отображается на экране
        Assert.assertEquals(onlinerPage.getSearchInput().getAttribute("value"), productName);
    }

    @Test
    public void actionJSExecutorTest2() {

        // Открыть Onliner.by
        OnlinerPage onlinerPage = new OnlinerPage(browserService, true);
        JavascriptExecutor js = (JavascriptExecutor) browserService.getDriver();
        // 1ый вариант - скролл до элемента в конце страницы
        js.executeScript("arguments[0].scrollIntoView();", onlinerPage.getFooter());


        // 2ой вариант - скролл до конца страницы
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Assert.assertTrue(onlinerPage.getCompanyInfoLink().isDisplayed());
    }
}
