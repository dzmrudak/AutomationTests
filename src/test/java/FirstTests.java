import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTests {
    public FirstTests() {
    }

    @Test
    public void chromeDriverTest() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());

        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/weight-and-calories/body-mass-index-calculator.html");

        WebElement height = driver.findElement(By.id("bmiVar1"));
        height.sendKeys("183");

        WebElement weight = driver.findElement(By.name("bmiVar2"));
        weight.sendKeys("58");

        WebElement calcBtn = driver.findElement(By.className("btn-calculate"));
        calcBtn.click();

        WebElement bmiNumber = driver.findElement(By.id("AnswerBMI"));
        String bmiNumberText = bmiNumber.getText();

        WebElement status = driver.findElement(By.id("AnswerBMI1"));
        String statusText = status.getText();

        Assert.assertEquals(bmiNumberText, "17.32", "Ваш индекс отображает неверное значение");
        Assert.assertEquals(statusText, "Недостаточной массе тела", "Некорректный статус");

        driver.quit();
    }

    @Test
    public void smokeTest1() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());

        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        Select selectLayingMethodLaminate = new Select(selectWebElement);
        selectLayingMethodLaminate.selectByIndex(0);
        selectLayingMethodLaminate.selectByValue("0");
        selectLayingMethodLaminate.selectByVisibleText("с использованием отрезанного элемента");
        driver.quit();
    }

    // Home Task Smoke Test 2: https://calc.by/building-calculators/laminate.html
    @Test
    public void smokeTest2() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());

        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));

        Select selectLayingMethodLaminate = new Select(selectWebElement);
        selectLayingMethodLaminate.selectByVisibleText("с использованием отрезанного элемента");

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");

        WebElement panelLength = driver.findElement(By.id("ln_lam_id"));
        panelLength.clear();
        panelLength.sendKeys("2000");

        WebElement panelWidth = driver.findElement(By.id("wd_lam_id"));
        panelWidth.clear();
        panelWidth.sendKeys("200");

        WebElement radioBtn = driver.findElement(By.id("direction-laminate-id1"));
        radioBtn.click();

        WebElement caclBtn = driver.findElement(By.linkText("Рассчитать"));
        caclBtn.click();

        try {
            Thread.sleep(1200);
        } catch (InterruptedException var17) {
            var17.printStackTrace();
        }

        WebElement result = driver.findElement(By.xpath("//div[@class='calc-result']/div[1]"));
        String statusText = result.getText();
        Assert.assertEquals(statusText, "Требуемое количество досок ламината: 53");

        WebElement result1 = driver.findElement(By.xpath("//div[@class='calc-result']/div[2]"));
        String statusText1 = result1.getText();
        Assert.assertEquals(statusText1, "Количество упаковок ламината: 7");

        driver.quit();
    }

    // Home Task Test1: https://masterskayapola.ru/kalkulyator/laminata.html
    @Test
    public void smokeTest3() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());

        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        Actions actions = new Actions(driver);

        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
        actions.keyDown(roomLength, Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        roomLength.sendKeys("6");

        WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
        actions.keyDown(roomWidth, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        roomWidth.sendKeys("5");

        WebElement lamPanelLength = driver.findElement(By.name("calc_lamwidth"));
        actions.keyDown(lamPanelLength, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        lamPanelLength.sendKeys("1200");

        WebElement lamPanelWidth = driver.findElement(By.name("calc_lamheight"));
        actions.keyDown(lamPanelWidth, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        lamPanelWidth.sendKeys("200");

        WebElement panelsPerPack = driver.findElement(By.name("calc_inpack"));
        actions.keyDown(panelsPerPack, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        panelsPerPack.sendKeys("15");

        WebElement pricePerPack = driver.findElement(By.name("calc_price"));
        actions.keyDown(pricePerPack, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        pricePerPack.sendKeys("500");

        WebElement selectWebElement = driver.findElement(By.name("calc_direct"));
        Select selectLayingDirection = new Select(selectWebElement);
        selectLayingDirection.selectByVisibleText("По длине комнаты");

        WebElement rowsOffset = driver.findElement(By.name("calc_bias"));
        actions.keyDown(rowsOffset, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        rowsOffset.sendKeys("250");

        WebElement wallDist = driver.findElement(By.name("calc_walldist"));
        actions.keyDown(wallDist, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        wallDist.sendKeys("15");

        WebElement calcBtn = driver.findElement(By.xpath("//input[@value='Рассчитать']"));
        calcBtn.click();

        try {
            Thread.sleep(1200L);
        } catch (InterruptedException var41) {
            var41.printStackTrace();
        }

        WebElement resultText = driver.findElement(By.xpath("//span[text() = 'Площадь укладки:']"));
        String result = resultText.getText();
        Assert.assertEquals(result, "Площадь укладки:");

        WebElement laySquareResult = driver.findElement(By.id("s_lam"));
        String statusText = laySquareResult.getText();
        Assert.assertEquals(statusText, "29.67 м2.");

        WebElement panelNumText = driver.findElement(By.xpath("//span[text() = 'Кол-во панелей:']"));
        String panelNum = panelNumText.getText();
        Assert.assertEquals(panelNum, "Кол-во панелей:");

        WebElement panelNumResult = driver.findElement(By.id("l_count"));
        String statusText1 = panelNumResult.getText();
        Assert.assertEquals(statusText1, "127 шт.");

        WebElement packsNumText = driver.findElement(By.xpath("//span[text() = 'Кол-во упаковок:']"));
        String packsNum = packsNumText.getText();
        Assert.assertEquals(packsNum, "Кол-во упаковок:");

        WebElement packsNumResult = driver.findElement(By.id("l_packs"));
        String statusText2 = packsNumResult.getText();
        Assert.assertEquals(statusText2, "9 шт.");

        WebElement priceText = driver.findElement(By.xpath("//span[text() = 'Стоимость:']"));
        String price = priceText.getText();
        Assert.assertEquals(price, "Стоимость:");

        WebElement priceResult = driver.findElement(By.id("l_price"));
        String statusText3 = priceResult.getText();
        Assert.assertEquals(statusText3, "16200 руб.");

        WebElement remainsNumText = driver.findElement(By.xpath("//span[text() = 'Остатки:']"));
        String remainsNum = remainsNumText.getText();
        Assert.assertEquals(remainsNum, "Остатки:");

        WebElement remainsNumResult = driver.findElement(By.id("l_over"));
        String statusText4 = remainsNumResult.getText();
        Assert.assertEquals(statusText4, "8 шт.");

        WebElement segmentsNumText = driver.findElement(By.xpath("//span[text() = 'Отрезки:']"));
        String segmentsNum = segmentsNumText.getText();
        Assert.assertEquals(segmentsNum, "Отрезки:");

        WebElement segmentsNumResult = driver.findElement(By.id("l_trash"));
        String statusText5 = segmentsNumResult.getText();
        Assert.assertEquals(statusText5, "9 шт.");

        driver.quit();
    }

    // Home Task Test1: https://masterskayapola.ru/kalkulyator/laminata.html
    @Test
    public void smokeTest4() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());

        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        Actions actions = new Actions(driver);

        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
        actions.keyDown(roomLength, Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        roomLength.sendKeys("20");

        WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
        actions.keyDown(roomWidth, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        roomWidth.sendKeys("15");

        WebElement lamPanelLength = driver.findElement(By.name("calc_lamwidth"));
        actions.keyDown(lamPanelLength, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        lamPanelLength.sendKeys("1200");

        WebElement lamPanelWidth = driver.findElement(By.name("calc_lamheight"));
        actions.keyDown(lamPanelWidth, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        lamPanelWidth.sendKeys("200");

        WebElement panelsPerPack = driver.findElement(By.name("calc_inpack"));
        actions.keyDown(panelsPerPack, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        panelsPerPack.sendKeys("15");

        WebElement pricePerPack = driver.findElement(By.name("calc_price"));
        actions.keyDown(pricePerPack, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        pricePerPack.sendKeys("500");

        WebElement selectWebElement = driver.findElement(By.name("calc_direct"));
        Select selectLayingDirection = new Select(selectWebElement);
        selectLayingDirection.selectByVisibleText("По ширине комнаты");

        WebElement rowsOffset = driver.findElement(By.name("calc_bias"));
        actions.keyDown(rowsOffset, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        rowsOffset.sendKeys("250");

        WebElement wallDist = driver.findElement(By.name("calc_walldist"));
        actions.keyDown(wallDist, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        wallDist.sendKeys("15");

        WebElement calcBtn = driver.findElement(By.xpath("//input[@value='Рассчитать']"));
        calcBtn.click();

        try {
            Thread.sleep(1200);
        } catch (InterruptedException var41) {
            var41.printStackTrace();
        }

        WebElement resultText = driver.findElement(By.xpath("//span[text() = 'Площадь укладки:']"));
        String result = resultText.getText();
        Assert.assertEquals(result, "Площадь укладки:");

        WebElement laySquareResult = driver.findElement(By.id("s_lam"));
        String statusText = laySquareResult.getText();
        Assert.assertEquals(statusText, "149.25 м2.");

        WebElement panelNumText = driver.findElement(By.xpath("//span[text() = 'Кол-во панелей:']"));
        String panelNum = panelNumText.getText();
        Assert.assertEquals(panelNum, "Кол-во панелей:");

        WebElement panelNumResult = driver.findElement(By.id("l_count"));
        String statusText1 = panelNumResult.getText();
        Assert.assertEquals(statusText1, "630 шт.");

        WebElement packsNumText = driver.findElement(By.xpath("//span[text() = 'Кол-во упаковок:']"));
        String packsNum = packsNumText.getText();
        Assert.assertEquals(packsNum, "Кол-во упаковок:");

        WebElement packsNumResult = driver.findElement(By.id("l_packs"));
        String statusText2 = packsNumResult.getText();
        Assert.assertEquals(statusText2, "42 шт.");

        WebElement priceText = driver.findElement(By.xpath("//span[text() = 'Стоимость:']"));
        String price = priceText.getText();
        Assert.assertEquals(price, "Стоимость:");

        WebElement priceResult = driver.findElement(By.id("l_price"));
        String statusText3 = priceResult.getText();
        Assert.assertEquals(statusText3, "75600 руб.");

        WebElement remainsNumText = driver.findElement(By.xpath("//span[text() = 'Остатки:']"));
        String remainsNum = remainsNumText.getText();
        Assert.assertEquals(remainsNum, "Остатки:");

        WebElement remainsNumResult = driver.findElement(By.id("l_over"));
        String statusText4 = remainsNumResult.getText();
        Assert.assertEquals(statusText4, "0 шт.");

        WebElement segmentsNumText = driver.findElement(By.xpath("//span[text() = 'Отрезки:']"));
        String segmentsNum = segmentsNumText.getText();
        Assert.assertEquals(segmentsNum, "Отрезки:");

        WebElement segmentsNumResult = driver.findElement(By.id("l_trash"));
        String statusText5 = segmentsNumResult.getText();
        Assert.assertEquals(statusText5, "15 шт.");

        driver.quit();
    }
}

