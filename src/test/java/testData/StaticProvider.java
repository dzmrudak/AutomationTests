package testData;

import enums.ProjectType;
import models.Project;
import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "Create Project")
    public static Object[][] createData(){
        return new Object[][] {
                {"Project 1", new Project("DR project 1", "announcement1", true, ProjectType.SINGLE_FOR_ALL_CASES)},
                {"Project 2", new Project("DR project 2", "announcement2", false, ProjectType.SINGLE_WITH_BASELINE)},
                {"Project 3", new Project("DR project 3", "announcement3", true, ProjectType.MULTIPLE)}
        };
    }

    @DataProvider(name = "Update Project")
    public static Object[][] updateData(){
        return new Object[][] {
                {"Project 1", new Project("DR project 1", "announcement1 UPDATED", false, ProjectType.MULTIPLE)},
                {"Project 2", new Project("DR project 2", "announcement2 UPDATED", true, ProjectType.SINGLE_FOR_ALL_CASES)},
                {"Project 3", new Project("DR project 3", "announcement3 UPDATED", false, ProjectType.SINGLE_WITH_BASELINE)}
        };
    }

    @DataProvider(name = "Delete Project")
    public static Object[][] deleteData(){
        return new Object[][] {
                {"Project 1", new Project("DR project 1", "announcement1", true, ProjectType.SINGLE_FOR_ALL_CASES)},
                {"Project 2", new Project("DR project 2", "announcement2", false, ProjectType.SINGLE_WITH_BASELINE)},
                {"Project 3", new Project("DR project 3", "announcement3", true, ProjectType.MULTIPLE)}
        };
    }
}
