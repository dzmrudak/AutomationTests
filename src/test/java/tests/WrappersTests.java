package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewProjectPage;
import pages.AllProjectsPage;
import pages.DashboardPage;
import pages.ProjectPage;
import steps.LoginSteps;
import wrappers.UIElement;

public class WrappersTests extends BaseTest {

    @Test
    public void wrapperTest() {
        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        browserService.getDriver().get("https://aqa04onl03.testrail.io/index.php?/admin/projects/edit/4109");

        UIElement button = new UIElement(browserService.getDriver(), By.className("icon-markdown-table"));
        button.hover();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wrapperTableTest()  {
        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        browserService.getDriver().get("https://aqa04onl03.testrail.io/index.php?/admin/projects/overview");


        AllProjectsPage projectsPage = new AllProjectsPage(browserService, false );
        System.out.println(projectsPage.projectTable.rowsCount());
        System.out.println(projectsPage.projectTable.getCellsCountForRow(1 ));
        //WebElement rowElement = projectPage.getRowForElementInTable
    }

    @Test
    public void wrapperCheckboxTest()  {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getProjectNameTitle("dRudakProject1").click();

        ProjectPage projectPage = new ProjectPage(browserService, false);
        projectPage.getEditButton().click();

        AddNewProjectPage projectEditPage = new AddNewProjectPage(browserService, false);
        if (!projectEditPage.getAnnouncementBox().isSelected()) {
            projectEditPage.getAnnouncementBox().click();
        }

        if(projectEditPage.getAcceptProjectButton().isEnabled()){
            projectEditPage.getAcceptProjectButton().click();
            Assert.assertTrue(projectPage.getSuccessMessage().isDisplayed());
        } else {
            projectEditPage.getCancelProjectButton().click();
        }
    }

    @Test
    public void wrapperRadioButtonTest()  {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getProjectNameTitle("dRudakProject1").click();

        ProjectPage projectPage = new ProjectPage(browserService, false);
        projectPage.getEditButton().click();

        AddNewProjectPage projectEditPage = new AddNewProjectPage(browserService, false);
        String optionName1 = ("Use a single repository for all cases (recommended)");
        String optionName2 = ("Use a single repository with baseline support");
        String optionName3 = ("Use multiple test suites to manage cases");

        if(projectEditPage.getProjectTypeRadioButton().isOptionSelected(optionName1)) {
            projectEditPage.getProjectTypeRadioButton().selectByOption(optionName3);
        } else if (projectEditPage.getProjectTypeRadioButton().isOptionSelected(optionName2)){
            projectEditPage.getProjectTypeRadioButton().selectByOption(optionName3);
        } else {
            projectEditPage.getProjectTypeRadioButton().selectByOption(optionName1);
        }

        projectEditPage.getAcceptProjectButton().click();

        Assert.assertTrue(projectPage.getSuccessMessage().isDisplayed());
    }

    @Test
    public void wrapperDropDownMeuTest()  {
        LoginSteps loginSteps = new LoginSteps(browserService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getNavigationUserDropDown().click();
        dashboardPage.getNavigationUserDropDownMenu().selectByOption("My Settings");

        Assert.assertEquals(browserService.getDriver().findElement(By.xpath("//div[contains(@class, 'page_title')]")).getText(), "My Settings");
    }
}
