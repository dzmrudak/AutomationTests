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
                {"Project 1", new Project("DR project 1", "announcement1", true, ProjectType.SINGLE_FOR_ALL_CASES)},
                //{"Project 2", new Project("DR project 2", "announcement2", false, ProjectType.SINGLE_WITH_BASELINE)},
                //{"Project 3", new Project("DR project 3", "announcement3", true, ProjectType.MULTIPLE)}
        };
    }

    @DataProvider(name = "Create Test Case")
    public static Object[][] createTestCase() {
        return new Object[][] {
                {"Test Case 1", new TestCase("TestCase1", Section.TEST_CASES, Template.TEST_CASE_TEXT, Type.REGRESSION, Priority.MEDIUM)}
        };
    }
}
