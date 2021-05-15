package tests;

import com.google.gson.Gson;
import core.BrowserService;
import dao.ProjectDaoImplementation;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AllProjectsPage;
import pages.DashboardPage;
import sevices.DatabaseConnection;
import sevices.JdbcService;
import steps.LoginSteps;
import steps.ProjectServiceSteps;
import testData.StaticProvider;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlTest{

    static Logger logger = LogManager.getLogger(SqlTest.class);
    static final int PROJECT_ID = 4;
    BrowserService browserService = new BrowserService();

    @Test
    public void connectionTest() throws SQLException {

        JdbcService jdbcService = new JdbcService();

        ResultSet resultSet = jdbcService.executeQuery("select * from customers;");

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString(3);
            String email = resultSet.getString("email");
            int age = resultSet.getShort("age");

            logger.info("Result: id = " + id + ", firstname = " + firstName + ", lastname = " + lastName +
                    ", email = " + email + ", age = " + age);
        }

        jdbcService.closeConnection();
    }

    @SneakyThrows
    @BeforeTest
    public void setUp() {
        ProjectDaoImplementation prDao = new ProjectDaoImplementation();

        prDao.drop();
        //prDao.create();
    }

    @SneakyThrows
    @Test
    public void test1AddProject() {
        ProjectDaoImplementation prDao = new ProjectDaoImplementation();

        Project project = Project.builder()
                .name("PR06")
                .announcement("PR06_Announ")
                .showAnnouncement(true)
                .type(1)
                .build();

        System.out.println(prDao.add(project));
        System.out.println(prDao.add(project));
    }

    @SneakyThrows
    @Test
    public void test2UpdateProject() {
        ProjectDaoImplementation prDao = new ProjectDaoImplementation();

        Project project = Project.builder()
                .id(PROJECT_ID)
                .name("PR08 UPDATED")
                .announcement("PR06_Announ UPDATED")
                .showAnnouncement(true)
                .type(2)
                .build();

        System.out.println(prDao.update(project));
    }

    @SneakyThrows
    @Test
    public void test3ShowProject() {
        ProjectDaoImplementation prDao = new ProjectDaoImplementation();

        Project project = prDao.getProject(PROJECT_ID);
        System.out.println(project.toString());
    }

    @SneakyThrows
    @Test
    public void test4ShowAllProjects() {
        ProjectDaoImplementation prDao = new ProjectDaoImplementation();

        for(Project pr : prDao.getProjects()) {
            System.out.println(pr.toString());
        }
    }

    @SneakyThrows
    @Test
    public void test5DeleteProject() {
        ProjectDaoImplementation prDao = new ProjectDaoImplementation();

        System.out.println(prDao.delete(PROJECT_ID));
    }

    @Feature("Feature2")
    @Story("Story2")
    @TmsLink("16")
    @Owner("Dzmitry Rudak")
    @Issue("QO-88")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create Project from DB by Project ID", dataProvider = "Create Project within API", dataProviderClass = StaticProvider.class)
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

    @SneakyThrows
    @Test(description = "Compare a project from DB and a project from API request",dependsOnMethods = "createProjectTest")
    public void compareProjects() {
        ProjectDaoImplementation prDao = new ProjectDaoImplementation();
        Gson gson = new Gson();
        RestAssured.baseURI = "https://aqa04onl04.testrail.io/";
        int projectId = Integer.MIN_VALUE;
        int projectType = Integer.MIN_VALUE;
        String getProjects = "index.php?/api/v2/get_projects";

        Project projectFromDB = prDao.getProject(PROJECT_ID);
        Project projectFromUI = null;

        RequestSpecification request = RestAssured.given()
                .auth()
                .preemptive()
                .basic("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Response response = request.request(Method.GET, getProjects);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        String responseBody = response.getBody().asString();

        Project[] arrayOfProjects = gson.fromJson(responseBody, Project[].class);
        for(Project project: arrayOfProjects) {
            if(project.getName().equals(projectFromDB.getName())){
                projectId = project.getId();
                projectType = project.getType();
                break;
            }
        }
        request = RestAssured.given()
                .auth()
                .preemptive()
                .basic("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        String getProject = "index.php?/api/v2/get_project/" + projectId;

        Response response1 = request.request(Method.GET, getProject);
        String responseBody1 = response1.getBody().asString();
        projectFromUI = gson.fromJson(responseBody1, Project.class);
        projectFromUI.setType(projectType);

        Assert.assertEquals(projectFromUI, projectFromDB);
    }

    @AfterTest
    public void tearDown() {
        DatabaseConnection.closeConnection();
        browserService.getDriver().quit();
        System.out.println("Connection has been closed");
    }
}
