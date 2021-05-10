package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.AllProjectsPage;
import pages.EditProjectPage;
import pages.ProjectPage;
import steps.ProjectServiceSteps;
import steps.LoginSteps;

public class SmokeTest1 extends BaseTest {

    @Test
    public void LoginTest() {
        //1. Запустить дравйвер
        //2. Перейти на сайт
        //3. Ввести логин
        //4. Ввести пароль
        //5. Нажать кнопку Логин
        //6. Dashboard page отобразился

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browserService.getDriver().getTitle(), "All Projects - TestRail");

    }

    @Test(expectedExceptions = AssertionError.class)
    public void LoginTestWithIncorrectCredentialsEmailEnteredPswEntered() { //throws InterruptedException
        //1. Запустить дравйвер
        //2. Перейти на сайт
        //3. Ввести невалидный логин
        //4. Ввести невалидный пароль
        //5. Нажать кнопку Логин
        //6. Появляется ошибка и сообщение о некорректных данных

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("test@gmail.com", "qweqwe");

        //Assert.assertEquals(loginPage.getErrorText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(expectedExceptions = AssertionError.class)
    public void LoginTestWithIncorrectCredentialsEmailEmptyPswEntered() { //throws InterruptedException
        //1. Запустить дравйвер
        //2. Перейти на сайт
        //3. Оставить поле логин пустым
        //4. Ввести пароль
        //5. Нажать кнопку Логин
        //6. Появляется ошибка и сообщение о некорректных данных

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("", "QqtRK9elseEfAk6ilYcJ");
    }

    @Test(expectedExceptions = AssertionError.class)
    public void LoginTestWithIncorrectCredentialsEmailEnteredPswEmpty() { //throws InterruptedException
        //1. Запустить дравйвер
        //2. Перейти на сайт
        //3. Оставить поле логин пустым
        //4. Ввести пароль
        //5. Нажать кнопку Логин
        //6. Появляется ошибка и сообщение о некорректных данных

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "");
    }

    @Test
    public void addNewProjectTest() {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        Project project = Project.builder()
                .name("Test Project DR")
                .announcement("Test Project Definition")
                .isShowAnnouncement(true)
                .type(ProjectType.MULTIPLE)
                .build();

        ProjectServiceSteps createProjectSteps = new ProjectServiceSteps(browserService);
        AllProjectsPage projectsPage = createProjectSteps.addProject(project);

        Assert.assertEquals(projectsPage.getSuccessMessage().getText(), "Successfully added the new project.");
        Assert.assertEquals(projectsPage.getProjectName(project.getName()), project.getName());

    }

    @Test(dependsOnMethods = "addNewProjectTest")
    public void updateProjectTest() {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Project project = Project.builder()
                .name("Test Project DR")
                .announcement("Test Project Definition UPDATED")
                .isShowAnnouncement(true)
                .type(ProjectType.MULTIPLE)
                .build();

        dashboardPage.getProjectNameTitle(project.getName()).click();

        ProjectPage projectPage = new ProjectPage(browserService, false);
        projectPage.getEditButton().click();

        ProjectServiceSteps editProjectPage = new ProjectServiceSteps(browserService);
        editProjectPage.updateProject(project);

        Assert.assertEquals(projectPage.getSuccessMessage().getText(), "Successfully updated the project.");
    }

    @Test(dependsOnMethods = "addNewProjectTest")
    public void deleteProjectTest() {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getAdministrationButton().click();

        AllProjectsPage allProjectsPage = new AllProjectsPage(browserService, true);
        allProjectsPage.getProjectsTab().click();

        Project project = Project.builder()
                .name("Test Project DR")
                .announcement("Test Project Definition UPDATED")
                .isShowAnnouncement(true)
                .type(ProjectType.MULTIPLE)
                .build();

        Assert.assertEquals(allProjectsPage.getSuccessMessage().getText(), "Successfully deleted the project.");
    }
}
