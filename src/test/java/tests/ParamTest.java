package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

//    @Test(dataProvider = "Create Project", dataProviderClass = StaticProvider.class)
//    public void createProjectTest(String projectName, ProjectType projectType){
//
//    }

    @Parameters({"first-name", "last-name"})
    @Test
    public void paramTest(@Optional("Alex1") String firstName, @Optional("Test") String lastName){
        System.out.println("First Name " + firstName);
        System.out.println("Last Name " + lastName);
    }
}
