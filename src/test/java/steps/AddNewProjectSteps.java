package steps;

import core.BrowserService;
import pages.AddProjectsPage;
import pages.ProjectsPage;

public class AddNewProjectSteps {

    private BrowserService browserService;

    public AddNewProjectSteps(BrowserService browserService){
        this.browserService = browserService;
    }

    public ProjectsPage addNewProjectForAllCases(String name, String announcements){
        AddProjectsPage addProjectsPage = new AddProjectsPage(browserService, false);
        addProjectsPage.getProjectTab().click();
        addProjectsPage.getProjectNameInput().sendKeys(name);
        addProjectsPage.getAnnouncementInput().sendKeys(announcements);
        addProjectsPage.getAnnouncementBox().isSelected();
        addProjectsPage.getProjectType1RadioButton().isSelected();
        addProjectsPage.getAddProjectButton().click();

        return new ProjectsPage(browserService, false);
    }

    public ProjectsPage addNewProjectWithBaseLineSupport(String name, String announcements){
        AddProjectsPage addProjectsPage = new AddProjectsPage(browserService, false);
        addProjectsPage.getProjectTab().click();
        addProjectsPage.getProjectNameInput().sendKeys(name);
        addProjectsPage.getAnnouncementInput().sendKeys(announcements);
        addProjectsPage.getAnnouncementBox().isSelected();
        addProjectsPage.getProjectType2RadioButton().click();
        addProjectsPage.getAddProjectButton().click();

        return new ProjectsPage(browserService, false);
    }

    public ProjectsPage addNewProjectWithMultiTestSuites(String name, String announcements){
        AddProjectsPage addProjectsPage = new AddProjectsPage(browserService, false);
        addProjectsPage.getProjectTab().click();
        addProjectsPage.getProjectNameInput().sendKeys(name);
        addProjectsPage.getAnnouncementInput().sendKeys(announcements);
        addProjectsPage.getAnnouncementBox().isSelected();
        addProjectsPage.getProjectType3RadioButton().click();
        addProjectsPage.getAddProjectButton().click();

        return new ProjectsPage(browserService, false);
    }
}
