package testData;

import dao.ProjectDaoImplementation;
import enums.ProjectType;
import enums.testCaseAttributes.Priority;
import enums.testCaseAttributes.Section;
import enums.testCaseAttributes.Template;
import enums.testCaseAttributes.Type;
import lombok.SneakyThrows;
import models.Project;
import models.TestCase;
import org.testng.annotations.DataProvider;


public class StaticProvider {

    @SneakyThrows
    @DataProvider(name = "Create Project within API")
    public static Object[][] createDataAPI(){
        ProjectDaoImplementation prDao = new ProjectDaoImplementation();
        return new Object[][] {
                {"Project 1", prDao.getProject(2)}
        };
    }

    @DataProvider(name = "Create Project with Builder")
    public static Object[][] createData(){
        return new Object[][] {
                {"Project 1", Project.builder()
                        .name("DR project 1")
                        .announcement("announcement")
                        .showAnnouncement(false)
                        .type(1)
                        .build()}
        };
    }

    @DataProvider(name = "Update Project")
    public static Object[][] updateData(){
        return new Object[][] {
                {"Project 1", Project.builder()
                        .name("DR project 1")
                        .announcement("announcement UPDATED")
                        .showAnnouncement(true)
                        .type(3)
                        .build()}
        };
    }

    @DataProvider(name = "Delete Project")
    public static Object[][] deleteData(){
        return new Object[][] {
                {"Project 1", Project.builder()
                        .name("DR project 1")
                        .announcement("announcement UPDATED")
                        .showAnnouncement(true)
                        .type(3)
                        .build()}
        };
    }

    @DataProvider(name = "Create Test Case")
    public static Object[][] createTestCase(){
        return new Object[][] {
                {"Test Case 1", TestCase.builder()
                        .title("TestCase1")
                        .section(Section.TEST_CASES)
                        .template(Template.TEST_CASE_TEXT)
                        .type(Type.REGRESSION)
                        .priority(Priority.MEDIUM)
                        .build()}
        };
    }

    @DataProvider(name = "Update Test Case")
    public static Object[][] updateTestCase() {
        return new Object[][] {
                {"Test Case 1", TestCase.builder()
                        .title("TestCase1")
                        .section(Section.TEST_CASES)
                        .template(Template.TEST_CASE_TEXT)
                        .type(Type.ACCEPTANCE)
                        .priority(Priority.MEDIUM)
                        .build()}
        };
    }

    @DataProvider(name = "Delete Test Case")
    public static Object[][] deleteTestCase() {
        return new Object[][] {
                {"Test Case 1", TestCase.builder()
                        .title("TestCase1")
                        .section(Section.TEST_CASES)
                        .template(Template.TEST_CASE_TEXT)
                        .type(Type.ACCEPTANCE)
                        .priority(Priority.MEDIUM)
                        .build()}

        };
    }
}
