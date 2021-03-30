import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class GUITests {

    @Test
    public void openTutByMain() {
        DriverManagerType driverManagerType = DriverManagerType.CHROME;
        WebDriverManager.getInstance(driverManagerType).setup();

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://tut.by");
        driver.findElement(By.name("topbar__link")).sendKeys("Hi, How are you?");
        driver.quit();
    }
}
