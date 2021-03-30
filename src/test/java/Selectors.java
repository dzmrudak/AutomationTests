import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Selectors {

    @Test
    public void cssSelectorsTest() {

        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());

        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://jobs.tut.by");

        driver.manage().window().maximize();
        //.class
        WebElement classSelector = driver.findElement(By.cssSelector(".supernova-overlay"));
        Assert.assertTrue(classSelector.isEnabled());
        //.class
        WebElement classSelector1 = driver.findElement(By.cssSelector(".supernova-dashboard-content"));
        Assert.assertTrue(classSelector1.isEnabled());

        //.class1.class2
        WebElement doubleClassSelector = driver.findElement(By.cssSelector(".HH-Supernova-Search-Container.supernova-navi-search-wrapper"));
        Assert.assertTrue(doubleClassSelector.isEnabled());
        //.class1.class2
        WebElement doubleClassSelector1 = driver.findElement(By.cssSelector(".supernova-footer.HH-Supernova-Footer"));
        Assert.assertTrue(doubleClassSelector1.isEnabled());

        //.class1 .class2
        WebElement underClassSelector = driver.findElement(By.cssSelector(".HH-Supernova-Search-Container .supernova-dashboard-navi"));
        Assert.assertTrue(underClassSelector.isEnabled());
        //.class1 .class2
        WebElement underClassSelector1 = driver.findElement(By.cssSelector(".supernova-dashboard-mobile-header .supernova-dashboard-mobile-inline-title"));
        Assert.assertTrue(underClassSelector1.isEnabled());

        //#id
        WebElement idSelector = driver.findElement(By.cssSelector("#topmailru-code"));
        Assert.assertTrue(idSelector.isEnabled());
        //#id
        WebElement idSelector1 = driver.findElement(By.cssSelector("#top100Counter"));
        Assert.assertTrue(idSelector1.isEnabled());

        //element
        WebElement elementSelector = driver.findElement(By.cssSelector("noindex"));
        Assert.assertTrue(elementSelector.isEnabled());
        //element
        List<WebElement> elementSelector1 = driver.findElements(By.cssSelector("h4"));
        Assert.assertEquals(elementSelector1.size(), 2);

        //element.class
        WebElement elementWithClassSelector = driver.findElement(By.cssSelector("div.supernova-dashboard-navi"));
        Assert.assertTrue(elementWithClassSelector.isEnabled());
        //element.class
        WebElement elementWithClassSelector1 = driver.findElement(By.cssSelector("p.supernova-footer-nav-cards"));
        Assert.assertTrue(elementWithClassSelector1.isEnabled());

        //element,element
        List<WebElement> diffElementTypeSelector = driver.findElements(By.cssSelector("h4, noindex"));
        Assert.assertEquals(diffElementTypeSelector.size(), 3);
        //element,element
        List<WebElement> diffElementTypeSelector1 = driver.findElements(By.cssSelector("h3, h4"));
        Assert.assertEquals(diffElementTypeSelector1.size(), 7);

        //element element
        WebElement elementInsideElementSelector = driver.findElement(By.cssSelector("div noindex"));
        Assert.assertTrue(elementInsideElementSelector.isEnabled());
        //element element
        List<WebElement> elementInsideElementSelector1 = driver.findElements(By.cssSelector("html h4"));
        Assert.assertEquals(elementInsideElementSelector1.size(), 2);

        //element>element
        WebElement parentElementSelector = driver.findElement(By.cssSelector("noindex > noscript"));
        Assert.assertTrue(parentElementSelector.isEnabled());
        //element>element
        List<WebElement> parentElementSelector1 = driver.findElements(By.cssSelector("div > h4"));
        Assert.assertEquals(parentElementSelector1.size(), 2);

        //element+element
        WebElement elementAfterElementSelector = driver.findElement(By.cssSelector("div + form"));
        Assert.assertTrue(elementAfterElementSelector.isEnabled());
        //element+element
        WebElement elementAfterElementSelector1 = driver.findElement(By.cssSelector("script + img"));
        Assert.assertTrue(elementAfterElementSelector1.isEnabled());

        //element1~element2
        WebElement precededElementSelector = driver.findElement(By.cssSelector("div ~ p"));
        Assert.assertTrue(precededElementSelector.isEnabled());
        //element1~element2
        WebElement precededElementSelector1 = driver.findElement(By.cssSelector("div ~ a"));
        Assert.assertTrue(precededElementSelector1.isEnabled());

        //[attribute]
        WebElement attributeSelector = driver.findElement(By.cssSelector("[sandbox]"));
        Assert.assertTrue(attributeSelector.isEnabled());
        //[attribute]
        List<WebElement> attributeSelector1 = driver.findElements(By.cssSelector("[data-empty-class]"));
        Assert.assertEquals(attributeSelector1.size(), 8);

        //[attribute=value]
        List <WebElement> attValSelector = driver.findElements(By.cssSelector("[type = \"text/javascript\"]"));
        Assert.assertEquals(attValSelector.size(), 13);
        //[attribute=value]
        WebElement attValSelector1 = driver.findElement(By.cssSelector("[title = Беларусь]"));
        Assert.assertTrue(attValSelector1.isEnabled());

        //[attribute~=value]
        WebElement attVal1Selector = driver.findElement(By.cssSelector("[title ~= Беларусь]"));
        Assert.assertTrue(attVal1Selector.isEnabled());
        //[attribute~=value]
        driver.get("https://tut.by");
        WebElement attVal1Selector1 = driver.findElement(By.cssSelector("[title ~= Главные]"));
        Assert.assertTrue(attVal1Selector1.isEnabled());

        //[attribute|=value]
        driver.get("https://jobs.tut.by");
        WebElement attVal2Selector = driver.findElement(By.cssSelector("[lang |= ru]"));
        Assert.assertTrue(attVal2Selector.isEnabled());
        //[attribute|=value]
        List<WebElement> attVal2Selector1 = driver.findElements(By.cssSelector("[class |= stay]"));
        Assert.assertEquals(attVal2Selector1.size(), 8);

        //[attribute^=value]
        List<WebElement> attVal3Selector = driver.findElements(By.cssSelector("input[placeholder ^= Профессия]"));
        Assert.assertEquals(attVal3Selector.size(), 2);
        //[attribute^=value]
        WebElement attVal3Selector1 = driver.findElement(By.cssSelector("input[class ^= supernova]"));
        Assert.assertTrue(attVal3Selector1.isEnabled());

        //[attribute$=value]
        WebElement attVal4Selector = driver.findElement(By.cssSelector("input[placeholder $= компания]"));
        Assert.assertTrue(attVal4Selector.isEnabled());
        //[attribute$=value]
        WebElement attVal4Selector1 = driver.findElement(By.cssSelector("input[class $= Suggest]"));
        Assert.assertTrue(attVal4Selector1.isEnabled());

        //[attribute*=value]
        List<WebElement> attVal5Selector = driver.findElements(By.cssSelector("input[placeholder *= или]"));
        Assert.assertEquals(attVal5Selector.size(), 2);
        //[attribute*=value]
        WebElement attVal5Selector1 = driver.findElement(By.cssSelector("input[class *= bold]"));
        Assert.assertTrue(attVal5Selector1.isEnabled());

        driver.quit();
    }

    @Test
    public void xpathSelectorsTest() {

        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());

        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://jobs.tut.by");
        driver.manage().window().maximize();

        // ancestor
        WebElement ancestorSelector = driver.findElement(By.xpath("//*[@class='dashboard-tiles-item__title']/ancestor::div[@data-title='Программист']"));
        Assert.assertTrue(ancestorSelector.isEnabled());
        // ancestor
        WebElement ancestorSelector1 = driver.findElement(By.xpath("//h3[@class = 'bloko-header-2']/ancestor::div[@class='bloko-column bloko-column_s-0 bloko-column_m-0 bloko-column_l-4']"));
        Assert.assertTrue(ancestorSelector1.isEnabled());

        // ancestor-or-self
        WebElement ancestorOrSelfSelector = driver.findElement(By.xpath("//img[@loading = 'lazy']/ancestor-or-self::img[@src = 'https://hhcdn.ru/nposter/265147.png' and @width='250']"));
        Assert.assertTrue(ancestorOrSelfSelector.isEnabled());
        // ancestor-or-self
        WebElement ancestorOrSelfSelector1 = driver.findElement(By.xpath("//a[@href='/catalog/Proizvodstvo']/ancestor-or-self::div[@class='index-section-catalog-wrapper']"));
        Assert.assertTrue(ancestorOrSelfSelector1.isEnabled());

        // attribute
        WebElement attributeSelector = driver.findElement(By.xpath("//button[attribute::class = 'bloko-button bloko-button_primary bloko-button_stretched bloko-button_large ']"));
        Assert.assertTrue(attributeSelector.isDisplayed());
        // attribute
        WebElement attributeSelector1 = driver.findElement(By.xpath("//ul[attribute::class='bloko-gap_bottom']"));
        Assert.assertTrue(attributeSelector1.isDisplayed());

        // child
        WebElement childSelector = driver.findElement(By.xpath("//div[@class='bloko-gap bloko-gap_top']/child::h1"));
        Assert.assertTrue(childSelector.isEnabled());
        // child
        WebElement childSelector1 = driver.findElement(By.xpath("//div[@class='bloko-column bloko-column_xs-0 bloko-column_s-8 bloko-column_m-12 bloko-column_l-16']/child::div[@class='separator']"));
        Assert.assertTrue(childSelector1.isEnabled());

        // descendant
        WebElement descendantSelector = driver.findElement(By.xpath("//div[@data-page-analytics-event=\"rainbowButton\"]/descendant::span[text() = 'Вакансии дня']"));
        Assert.assertTrue(descendantSelector.isEnabled());
        // descendant
        WebElement descendantSelector1 = driver.findElement(By.xpath("//*[@class='index-section-catalog-wrapper']/descendant::a[@href=\"/catalog/Avtomobilnyj-biznes\"]"));
        Assert.assertTrue(descendantSelector1.isEnabled());

        // descendant-or-self
        WebElement descendantOrSelfSelector = driver.findElement(By.xpath("//*[@class='bloko-gap bloko-gap_top']/descendant-or-self::h3[text() = 'Полезное']"));
        Assert.assertTrue(descendantOrSelfSelector.isEnabled());
        // descendant-or-self
        WebElement descendantOrSelfSelector1 = driver.findElement(By.xpath("//*[@class='index-news-box ']/descendant-or-self::a[@class='news-box-item__link']/img[@src=\"https://hhcdn.ru/file/16996092.jpg\"]"));
        Assert.assertTrue(descendantOrSelfSelector1.isEnabled());

        // following
        WebElement followingSelector = driver.findElement(By.xpath("//*[@class=\"supernova-button supernova-button_tinted supernova-button_secondary \"]/following::a[text()='Создать резюме']"));
        Assert.assertTrue(followingSelector.isEnabled());
        // following
        WebElement followingSelector1 = driver.findElement(By.xpath("//div[@class='bloko-gap bloko-gap_top']/following::div[last()]"));
        Assert.assertTrue(followingSelector1.isEnabled());

        // following-sibling
        WebElement followingSiblingSelector = driver.findElement(By.xpath("//h3[@class='bloko-header-2']/following-sibling::div/a[text()='Работа для программиста']"));
        Assert.assertTrue(followingSiblingSelector.isEnabled());
        // following-sibling
        WebElement followingSiblingSelector1 = driver.findElement(By.xpath("//h2[@class='bloko-header-2']/following-sibling::ul//span[text() = 'Работа в Витебске']"));
        Assert.assertTrue(followingSiblingSelector1.isEnabled());

        // parent
        WebElement parentSelector = driver.findElement(By.xpath("//li[@class='multiple-column-list-item']/parent::ul[@class='multiple-column-list multiple-column-list_narrow']"));
        Assert.assertTrue(parentSelector.isEnabled());
        // parent
        WebElement parentSelector1 = driver.findElement(By.xpath("//div[@class='dashboard-tiles-item__counter']/parent::div//div[text()='Подработка']"));
        Assert.assertTrue(parentSelector1.isEnabled());

        // preceding
        WebElement precedingSelector = driver.findElement(By.xpath("//a[@class='supernova-link HH-Supernova-NaviLevel2-Link']/preceding::div[@class='bloko-column bloko-column_xs-0 bloko-column_s-8 bloko-column_m-12 bloko-column_l-16']"));
        Assert.assertTrue(precedingSelector.isEnabled());
        // preceding
        List<WebElement> precedingSelector1 = driver.findElements(By.xpath("//input[@type='text']/preceding::a[@class='supernova-button supernova-button_tinted supernova-button_secondary ']"));
        Assert.assertEquals(precedingSelector1.size(), 2);

        // preceding-sibling
        WebElement precedingSiblingSelector = driver.findElement(By.xpath("//div[@class='bloko-gap bloko-gap_top']/preceding-sibling::p[@class='supernova-footer-nav-info-part']"));
        Assert.assertTrue(precedingSiblingSelector.isEnabled());
        // preceding-sibling
        WebElement precedingSiblingSelector1 = driver.findElement(By.xpath("//li[@class='supernova-footer-menu-item']/preceding-sibling::li/a[text()='Поиск сотрудников']"));
        Assert.assertTrue(precedingSiblingSelector1.isEnabled());

        //self
        WebElement selfSelector = driver.findElement(By.xpath("//div[@class='supernova-footer-nav']/descendant::a[@target='_blank']/self::a[@class='supernova-app-button supernova-app-button_ios ']"));
        Assert.assertTrue(selfSelector.isEnabled());
        //self
        WebElement selfSelector1 = driver.findElement(By.xpath("//div[@class='supernova-navi supernova-navi_lvl-1']/self::*"));
        Assert.assertTrue(selfSelector1.isEnabled());

        driver.quit();
    }

}
