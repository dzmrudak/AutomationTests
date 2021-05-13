package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.*;

public class ProjectServiceSteps extends BaseStep {

    public ProjectServiceSteps(BrowserService browserService) {
        super(browserService);
    }

    @Step("New Project details: 'project'")
    public AllProjectsPage addProject(Project project) {
        System.out.println(project.getName());
        System.out.println(project.getAnnouncement());
        System.out.println(project.isShowAnnouncement());
        System.out.println(project.getType());

        AddNewProjectPage addProjectsPage = new AddNewProjectPage(browserService, false);
        addProjectsPage.getProjectNameInput().sendKeys(project.getName());
        addProjectsPage.getAnnouncementInput().sendKeys(project.getAnnouncement());
        if (project.isShowAnnouncement()) {
            addProjectsPage.getAnnouncementBox().click();
        }
        switch (project.getType()) {
            case 1:
                addProjectsPage.getProjectType1RadioButton().click();
                break;
            case 2:
                addProjectsPage.getProjectType2RadioButton().click();
                break;
            case 3:
                addProjectsPage.getProjectType3RadioButton().click();
                break;
            default:
                break;
        }
        addProjectsPage.getAcceptProjectButton().click();
        return new AllProjectsPage(browserService, false);
    }

    public ProjectPage updateProject(Project project) {

        System.out.println(project.getName());
        System.out.println(project.getAnnouncement());
        System.out.println(project.isShowAnnouncement());
        System.out.println(project.getType());

        EditProjectPage editProjectsPage = new EditProjectPage(browserService, false);
        Actions actions = new Actions(browserService.getDriver());

        editProjectsPage.getProjectNameInput().click();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        editProjectsPage.getProjectNameInput().sendKeys(project.getName());

        editProjectsPage.getAnnouncementInput().click();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        editProjectsPage.getAnnouncementInput().sendKeys(project.getAnnouncement());


        if (project.isShowAnnouncement()) {
            editProjectsPage.getAnnouncementBox().click();
        }

        switch (project.getType()) {
            case 1:
                editProjectsPage.getProjectType1RadioButton().click();
                break;
            case 2:
                editProjectsPage.getProjectType2RadioButton().click();
                break;
            case 3:
                editProjectsPage.getProjectType3RadioButton().click();
                break;
            default:
                break;
        }

        editProjectsPage.getSaveProjectButton().click();

        return new ProjectPage(browserService, false);
    }

    public AllProjectsPage deleteProject(Project project) {

        AllProjectsPage deletingProject = new AllProjectsPage(browserService, false);
        deletingProject.getDeleteProjectButton(project.getName()).click();
        deletingProject.getConfirmDeletingBox().click();
        deletingProject.getConfirmDeletingProjectButton().click();

        return new AllProjectsPage(browserService, false);
    }
}
