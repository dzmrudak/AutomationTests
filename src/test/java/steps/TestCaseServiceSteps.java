package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AddNewTestCase;
import pages.TestCaseDetailedPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class TestCaseServiceSteps extends BaseStep {

    public TestCaseServiceSteps(BrowserService browserService) {
        super(browserService);
    }

    @Step("New Test Case: 'testCase'")
    public TestCaseDetailedPage addTestCase(TestCase testCase) {

        AddNewTestCase addNewTestCase = new AddNewTestCase(browserService, false);
        JavascriptExecutor js = (JavascriptExecutor) browserService.getDriver();
        Actions actions = new Actions(browserService.getDriver());

        addNewTestCase.getTitleNameInput().click();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        addNewTestCase.getTitleNameInput().sendKeys(testCase.getTitle());

        Select sectionDropDown = new Select(addNewTestCase.getSelectSection());
        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", addNewTestCase.getSelectSection());
        switch (testCase.getSection()) {
            case TEST_CASES:
                sectionDropDown.selectByVisibleText("Test Cases");
                break;
            default:
                break;
        }

        Select templateDropDown = new Select(addNewTestCase.getSelectTemplate());
        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", addNewTestCase.getSelectTemplate());
        switch (testCase.getTemplate()) {
            case TEST_CASE_STEPS:
                templateDropDown.selectByVisibleText("Test Case (Steps)");
                break;
            case TEST_CASE_TEXT:
                templateDropDown.selectByVisibleText("Test Case (Text)");
                break;
            case EXPLORATORY_SESSION:
                templateDropDown.selectByVisibleText("Exploratory Session");
                break;
            default:
                break;
        }

        Select typeDropDown = new Select(addNewTestCase.getSelectType());
        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", addNewTestCase.getSelectType());

        switch (testCase.getType()) {
            case ACCEPTANCE:
                typeDropDown.selectByVisibleText("Acceptance");
                break;
            case ACCESSIBILITY:
                typeDropDown.selectByVisibleText("Accessibility");
                break;
            case AUTOMATED:
                typeDropDown.selectByVisibleText("Automated");
                break;
            case COMPATIBILITY:
                typeDropDown.selectByVisibleText("Compatibility");
                break;
            case DESTRUCTIVE:
                typeDropDown.selectByVisibleText("Destructive");
                break;
            case FUNCTIONAL:
                typeDropDown.selectByVisibleText("Functional");
                break;
            case OTHER:
                typeDropDown.selectByVisibleText("Other");
                break;
            case PERFORMANCE:
                typeDropDown.selectByVisibleText("Performance");
                break;
            case REGRESSION:
                typeDropDown.selectByVisibleText("Regression");
                break;
            case SECURITY:
                typeDropDown.selectByVisibleText("Security");
                break;
            case SMOKE_N_SANITY:
                typeDropDown.selectByVisibleText("Smoke & Sanity");
                break;
            case USABILITY:
                typeDropDown.selectByVisibleText("Usability");
                break;
            default:
                break;
        }

        Select priorityDropDown = new Select(addNewTestCase.getSelectPriority());
        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", addNewTestCase.getSelectPriority());
        switch (testCase.getPriority()) {
            case CRITICAL:
                priorityDropDown.selectByVisibleText("Critical");
                break;
            case HIGH:
                priorityDropDown.selectByVisibleText("High");
                break;
            case MEDIUM:
                priorityDropDown.selectByVisibleText("Medium");
                break;
            case LOW:
                priorityDropDown.selectByVisibleText("Low");
                break;
            default:
                break;
        }

        addNewTestCase.getAcceptAddingTestCaseButton().click();

        return new TestCaseDetailedPage(browserService, false);
    }
}
