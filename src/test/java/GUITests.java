import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils;

import java.sql.Driver;
import java.sql.DriverManager;

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
