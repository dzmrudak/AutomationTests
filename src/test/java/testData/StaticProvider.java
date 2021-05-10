package testData;

import enums.ProjectType;
import enums.testCaseAttributes.Priority;
import enums.testCaseAttributes.Section;
import enums.testCaseAttributes.Template;
import enums.testCaseAttributes.Type;
import models.Project;
import models.TestCase;
import org.testng.annotations.DataProvider;


public class StaticProvider {

    @DataProvider(name = "Create Project")
    public static Object[][] createData(){
        return new Object[][] {
                {"Project 1", Project.builder()
                        .name("DR project 1")
                        .announcement("announcement1")
                        .isShowAnnouncement(true)
                        .type(ProjectType.SINGLE_FOR_ALL_CASES)
                        .build()}
        };
    }

    @DataProvider(name = "Update Project")
    public static Object[][] updateData(){
        return new Object[][] {
                {"Project 1", Project.builder()
                        .name("DR project 1")
                        .announcement("announcement UPDATED")
                        .isShowAnnouncement(true)
                        .type(ProjectType.MULTIPLE)
                        .build()}
        };
    }

    @DataProvider(name = "Delete Project")
    public static Object[][] deleteData(){
        return new Object[][] {
                {"Project 1", Project.builder()
                        .name("DR project 1")
                        .announcement("announcement UPDATED")
                        .isShowAnnouncement(true)
                        .type(ProjectType.MULTIPLE)
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
