package tests;

import baseEntities.BaseTest;
import models.Project;
import models.TestCase;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import steps.LoginSteps;
import steps.ProjectServiceSteps;
import steps.TestCaseServiceSteps;
import testData.StaticProvider;


public class ParamTest extends BaseTest {
    @Test(dataProvider = "Create Project", dataProviderClass = StaticProvider.class)
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
//
//    @Test(dataProvider = "Update Project", dataProviderClass = StaticProvider.class/*, dependsOnMethods = "createProjectTest"*/)
//    public void updateProjectTest(String projectName, Project project) {
//
//        LoginSteps loginSteps = new LoginSteps(browserService);
//        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
//
//        dashboardPage.getProjectNameTitle(project.getName()).click();
//        ProjectPage projectPage = new ProjectPage(browserService, false);
//        projectPage.getEditButton().click();
//
//        ProjectServiceSteps editProjectPage = new ProjectServiceSteps(browserService);
//        editProjectPage.updateProject(project);
//
//        Assert.assertEquals(projectPage.getSuccessMessage().getText(), "Successfully updated the project.");
//
//        System.out.println("Project name: " + projectName);
//        System.out.println("Project type: " + project);
//    }
//
//    @Test(dataProvider = "Delete Project", dataProviderClass = StaticProvider.class, dependsOnMethods = "updateProjectTest")
//    public void deleteProjectTest(String projectName, Project project) {
//
//        LoginSteps loginSteps = new LoginSteps(browserService);
//        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
//        dashboardPage.getAdministrationButton().click();
//
//        AllProjectsPage allProjectsPage = new AllProjectsPage(browserService, true);
//        allProjectsPage.getProjectsTab().click();
//
//        ProjectServiceSteps deletingProject = new ProjectServiceSteps(browserService);
//        deletingProject.deleteProject(project);
//
//        Assert.assertEquals(allProjectsPage.getSuccessMessage().getText(), "Successfully deleted the project.");
//
//        System.out.println("Project name: " + projectName);
//        System.out.println("Project type: " + project);
//
//    }

    @Test(dataProvider = "Create Test Case", dataProviderClass = StaticProvider.class, dependsOnMethods = "createProjectTest")
    public void createTestCase(String testCaseTitle, TestCase testCase) {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getProjectNameTitle("DR project 1").click();

        ProjectPage projectPage = new ProjectPage(browserService, false);
        projectPage.getTestsCasesMenuItem().click();

        TestCasesPage testCasesPage = new TestCasesPage(browserService, false);
        testCasesPage.getAddTestCaseButton().click();

        TestCaseServiceSteps addNewTestCase = new TestCaseServiceSteps(browserService);
        TestCaseDetailedPage newTestCase = addNewTestCase.addTestCase(testCase);

        Assert.assertEquals(newTestCase.getSuccessMessage().getText(), "Successfully added the new test case. Add another");

        System.out.println("Test Case name: " + testCaseTitle);
        System.out.println("Test Case Details: " + testCase);
    }

    @Test(dataProvider = "Update Test Case", dataProviderClass = StaticProvider.class, dependsOnMethods = "createTestCase")
    public void updateTestCase(String testCaseTitle, TestCase testCase) {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getProjectNameTitle("DR project 1").click();

        ProjectPage projectPage = new ProjectPage(browserService, false);
        projectPage.getTestsCasesMenuItem().click();

        SuiteDetailedPage suitePage = new SuiteDetailedPage(browserService, false);
        Actions action = new Actions(browserService.getDriver());

        action.moveToElement(suitePage.getEditTestCaseButton(testCase.getTitle())).perform();
        suitePage.getEditTestCaseButton(testCase.getTitle()).click();

        TestCaseServiceSteps updateTestCase = new TestCaseServiceSteps(browserService);
        TestCaseDetailedPage updatedTestCase = updateTestCase.addTestCase(testCase);

        Assert.assertEquals(updatedTestCase.getSuccessMessage().getText(), "Successfully updated the test case.");

        System.out.println("Test Case name: " + testCaseTitle);
        System.out.println("Test Case Details: " + testCase);
    }

    @Test(dataProvider = "Delete Test Case", dataProviderClass = StaticProvider.class/*, dependsOnMethods = "createTestCase", priority = 3*/)
    public void deleteTestCase(String testCaseTitle, TestCase testCase) {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getProjectNameTitle("DR project 1").click();

        ProjectPage projectPage = new ProjectPage(browserService, false);
        projectPage.getTestsCasesMenuItem().click();

        SuiteDetailedPage suitePage = new SuiteDetailedPage(browserService, false);
        Actions action = new Actions(browserService.getDriver());

        action.moveToElement(suitePage.getDeleteTestCaseButton(testCase.getTitle())).perform();
        suitePage.getDeleteTestCaseButton(testCase.getTitle()).click();
        suitePage.getDeleteTestCasePermanentlyButton().click();
        suitePage.getConfirmDeleteTestCasePermanentlyButton().click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertFalse(suitePage.getTestCaseLinkName(testCase.getTitle()).size() > 0);

        System.out.println("Test Case name: " + testCaseTitle);
        System.out.println("Test Case Details: " + testCase);
    }

//    @Parameters({"first-name", "last-name"})
//    @Test
//    public void paramTest(@Optional("Alex1") String firstName, @Optional("Test") String lastName) {
//        System.out.println("First Name " + firstName);
//        System.out.println("Last Name " + lastName);
//    }
}
