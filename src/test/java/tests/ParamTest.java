package tests;

import baseEntities.BaseTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AllProjectsPage;
import pages.DashboardPage;
import pages.ProjectPage;
import steps.LoginSteps;
import steps.ProjectServiceSteps;
import testData.StaticProvider;

public class ParamTest extends BaseTest {

    @Test(dataProvider = "Create Project", dataProviderClass = StaticProvider.class)
    public void createProjectTest(String projectName, Project project){

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

    @Test(dataProvider = "Update Project", dataProviderClass = StaticProvider.class/*, dependsOnMethods = "createProjectTest"*/)
    public void updateProjectTest(String projectName, Project project){

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

    @Test(dataProvider = "Delete Project", dataProviderClass = StaticProvider.class, dependsOnMethods = "updateProjectTest")
    public void deleteProjectTest(String projectName, Project project){

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

    @Parameters({"first-name", "last-name"})
    @Test
    public void paramTest(@Optional("Alex1") String firstName, @Optional("Test") String lastName){
        System.out.println("First Name " + firstName);
        System.out.println("Last Name " + lastName);
    }
}
