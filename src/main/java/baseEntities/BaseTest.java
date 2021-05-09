package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.testng.annotations.*;
import utils.Listener;
import utils.Waits;

import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public abstract class BaseTest {

    public BrowserService browserService;
    protected ReadProperties readProperties;
    protected Waits waits;

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
        browserService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        browserService.getDriver().get(readProperties.getURL());
        waits = browserService.getWaits();
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
