package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProjectsPage;
import pages.DashboardPage;
import pages.ProjectPage;
import steps.LoginSteps;
import steps.ProjectServiceSteps;
import testData.StaticProvider;

@Epic("Main Epic")
public class AllureTest extends BaseTest {

    @Feature("Feature1")
    @Story("Story1")
    @Flaky
    @Owner("Dzmitry Rudak")
    @TmsLink("16")
    @Link(name = "Text Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("QO-88")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login Test")
    @Description("Check with correct credentials")
    public void loginTest() {
        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browserService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Feature("Feature1")
    @Story("Story1")
    @Flaky
    @Owner("Dzmitry Rudak")
    @TmsLink("16")
    @Link(name = "Text Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("QO-88")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login Test", expectedExceptions = AssertionError.class)
    @Description("Check with incorrect credentials: Email is empty, correct pass entered")
    public void LoginTestWithIncorrectCredentialsEmailEmptyPswEntered() { //throws InterruptedException

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("", "QqtRK9elseEfAk6ilYcJ");
    }

    @Feature("Feature1")
    @Story("Story1")
    @Flaky
    @Owner("Dzmitry Rudak")
    @TmsLink("16")
    @Link(name = "Text Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("QO-88")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login Test", expectedExceptions = AssertionError.class)
    @Description("Check with incorrect credentials: Email entered, pass is empty")
    public void LoginTestWithIncorrectCredentialsEmailEnteredPswEmpty() { //throws InterruptedException
        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "");
    }

    @Feature("Feature1")
    @Story("Story1")
    @Flaky
    @Owner("Dzmitry Rudak")
    @TmsLink("16")
    @Link(name = "Text Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("QO-88")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login Test", expectedExceptions = AssertionError.class)
    @Description("Check with incorrect credentials: incorrect Email entered, incorrect pass entered")
    public void LoginTestWithIncorrectCredentialsEmailEnteredPswEntered() { //throws InterruptedException

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("test@gmail.com", "qweqwe");

        //Assert.assertEquals(loginPage.getErrorText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Feature("Feature2")
    @Story("Story2")
    @TmsLink("16")
    @Owner("Dzmitry Rudak")
    @Issue("QO-88")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create new project Test", dataProvider = "Create Project", dataProviderClass = StaticProvider.class)
    @Description("Create new project")
    public void createProjectTest(String projectName, Project project) {

        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        ProjectServiceSteps createProjectSteps = new ProjectServiceSteps(browserService);
        AllProjectsPage projectsPage = createProjectSteps.addProject(project);

        Assert.assertEquals(projectsPage.getSuccessMessage().getText(), "Successfully added the new project.");
        Assert.assertEquals(projectsPage.getProjectName(project.getName()), project.getName());

        System.out.println("Project name: " + projectName);
        System.out.println("Project type: " + project);
    }

    @Feature("Feature2")
    @Story("Story2")
    @TmsLink("16")
    @Owner("Dzmitry Rudak")
    @Link(name = "Text Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("QO-88")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Update an existing project Test", dataProvider = "Update Project", dataProviderClass = StaticProvider.class, dependsOnMethods = "createProjectTest")
    @Description("Update an existing project")
    public void updateProjectTest(String projectName, Project project) {

        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getProjectNameTitle(project.getName()).click();
        ProjectPage projectPage = new ProjectPage(browserService, false);
        projectPage.getEditButton().click();

        ProjectServiceSteps editProjectPage = new ProjectServiceSteps(browserService);
        editProjectPage.updateProject(project);

        Assert.assertEquals(projectPage.getSuccessMessage().getText(), "Successfully updated the project.");

        System.out.println("Project name: " + projectName);
        System.out.println("Project type: " + project);
    }

    @Feature("Feature2")
    @Story("Story2")
    @TmsLink("16")
    @Owner("Dzmitry Rudak")
    @Link(name = "Text Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("QO-88")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Delete an existing project Test", dataProvider = "Delete Project", dataProviderClass = StaticProvider.class, dependsOnMethods = "updateProjectTest")
    @Description("Delete an existing project")
    public void deleteProjectTest(String projectName, Project project) {

        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getAdministrationButton().click();

        AllProjectsPage allProjectsPage = new AllProjectsPage(browserService, true);
        allProjectsPage.getProjectsTab().click();

        ProjectServiceSteps deletingProject = new ProjectServiceSteps(browserService);
        deletingProject.deleteProject(project);

        Assert.assertEquals(allProjectsPage.getSuccessMessage().getText(), "Successfully deleted the project.");

        System.out.println("Project name: " + projectName);
        System.out.println("Project type: " + project);

    }
}
