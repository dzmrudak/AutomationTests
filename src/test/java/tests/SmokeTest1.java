package tests;

import core.BrowserService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectsPage;
import steps.AddNewProjectSteps;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

public class SmokeTest1 {

    @Test
    public void LoginTest(){
        //1. Запустить дравйвер
        //2. Перейти на сайт
        //3. Ввести логин
        //4. Ввести пароль
        //5. Нажать кнопку Логин
        //6. Dashboard page отобразился

        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        //driver.get(new ReadProperties().getUrl());

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(driver.getTitle(), "All Projects - TestRail");

        driver.quit();
    }

    @Test
    public void LoginTestWithIncorrectCredentials() throws InterruptedException {
        //1. Запустить дравйвер
        //2. Перейти на сайт
        //3. Ввести логин
        //4. Ввести пароль
        //5. Нажать кнопку Логин
        //6. Dashboard page отобразился

        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        //driver.get(new ReadProperties().getUrl());

        LoginSteps loginSteps = new LoginSteps(browserService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        Assert.assertEquals(loginPage.getErrorText(), "Email/Login or Password is incorrect. Please try again.");

        driver.quit();
    }

    @Test
    public void addNewProjectForAllCasesTest(){

        String testType = "dRudak_Project1";
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        //driver.get(new ReadProperties().getUrl());

        LoginSteps loginSteps = new LoginSteps(browserService);
        AddNewProjectSteps addNewProjectSteps = new AddNewProjectSteps(browserService);

        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getSidebarProjectsAddButton().click();

        ProjectsPage addProjectsPage = addNewProjectSteps.addNewProjectForAllCases(testType, "test announcement");

        Assert.assertEquals(addProjectsPage.getProjectName(testType), testType);

        driver.quit();
    }

    @Test
    public void addNewProjectWithBaseLineSupportTest(){

        String testType = "dRudak_Project2";
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        //driver.get(new ReadProperties().getUrl());

        LoginSteps loginSteps = new LoginSteps(browserService);
        AddNewProjectSteps addNewProjectSteps = new AddNewProjectSteps(browserService);

        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getSidebarProjectsAddButton().click();

        ProjectsPage addProjectsPage = addNewProjectSteps.addNewProjectWithBaseLineSupport(testType, "test announcement");

        Assert.assertEquals(addProjectsPage.getProjectName(testType), testType);

        driver.quit();
    }

    @Test
    public void addNewProjectWithMultiSuitesTest(){

        String testType = "dRudak_Project3";
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        //driver.get(new ReadProperties().getUrl());

        LoginSteps loginSteps = new LoginSteps(browserService);
        AddNewProjectSteps addNewProjectSteps = new AddNewProjectSteps(browserService);

        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getSidebarProjectsAddButton().click();

        ProjectsPage addProjectsPage = addNewProjectSteps.addNewProjectWithMultiTestSuites(testType, "test announcement");

        Assert.assertEquals(addProjectsPage.getProjectName(testType), testType);

        driver.quit();
    }
}
