package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected BrowserService browserService;
    protected ReadProperties readProperties;

    @BeforeSuite
    public void setupSuite(){
        System.out.println("BeforeSuite: ");
    }

    @BeforeGroups
    public void setupGroups(){
        System.out.println("BeforeGroups: ");
    }

    @BeforeTest
    public void setupTest(){
        System.out.println("BeforeTest: ");
        readProperties = new ReadProperties();
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("BeforeClass: ");
        readProperties = new ReadProperties();
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("BeforeMethod: ");
        browserService = new BrowserService();
        browserService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        browserService.getDriver().get(readProperties.getURL());
    }


    @AfterMethod
    public void tearDownMethod(){
        System.out.println("AfterMethod: ");
        browserService.getDriver().quit();
        browserService = null;
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("AfterClass: ");
    }

    @AfterTest
    public void tearDownTest(){
        System.out.println("AfterTest: ");
    }

    @AfterGroups
    public void tearDownGroups(){
        System.out.println("AfterGroups: ");
    }

    @AfterSuite
    public void tearDownSuite(){
        System.out.println("AfterSuite: ");
    }
}
