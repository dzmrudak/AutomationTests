package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private UIElement webElement;
    private List<TableRow> rowsList = new ArrayList<>();

    public Table(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
        int cellsCount = webElement.findElements(By.tagName("col")).size();
        for (WebElement webElement: webElement.findElements(By.tagName("tr"))) {
            TableRow tableRow = new TableRow(webDriver, webElement);
            tableRow.setCellsCount(cellsCount);
            rowsList.add(tableRow);
        }
    }

    public int rowsCount() {
        return rowsList.size();
    }

    public int getCellsCountForRow(int index) {
        return rowsList.get(index).getCellsCount();
    }
}
